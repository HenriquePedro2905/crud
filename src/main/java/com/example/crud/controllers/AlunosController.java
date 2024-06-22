package com.example.crud.controllers;

import com.example.crud.dolmain.aluno.Aluno;
import com.example.crud.dolmain.aluno.AlunoRepository;
import com.example.crud.dolmain.aluno.RequestAluno;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") //configuraçao para poder interagir com o font localmente
@RequestMapping("alunos")
public class AlunosController {

    @Autowired
    private AlunoRepository repository;
    @GetMapping
    public ResponseEntity getAllAlunos(){
        var allAlunos = repository.findAll();
        return ResponseEntity.ok(allAlunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlunosById(@RequestBody @Valid RequestAluno data){
        var alunosById = repository.findById(data.id());
        return ResponseEntity.ok(alunosById);
    }

    @PostMapping
    public ResponseEntity registerAluno(@RequestBody @Valid RequestAluno data){
        Aluno newAluno = new Aluno(data);
        repository.save(newAluno);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    @Transactional
    public  ResponseEntity updateAluno(@RequestBody @Valid RequestAluno data){
        Optional<Aluno> optionalAluno = repository.findById(data.id());
        if (optionalAluno.isPresent()){
            Aluno aluno = optionalAluno.get();
            aluno.setNome(data.nome());
            aluno.setIdade(data.idade());
            aluno.setTurma(data.turma());
            aluno.setCidade(data.cidade());
            return ResponseEntity.ok(aluno);
        } else {
            throw  new EntityNotFoundException();
        }
    }
}