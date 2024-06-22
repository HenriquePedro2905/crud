package com.example.crud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.crud.dolmain.professores.Professores;
import com.example.crud.dolmain.professores.ProfessoresRepository;
import com.example.crud.dolmain.professores.RequestProfessores;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") //configuraçao para poder interagir com o font localmente
@RequestMapping("professores")
public class ProfessoresController {

    @Autowired
    private ProfessoresRepository repository;
    @GetMapping
    public ResponseEntity getAllProfesores(){
        var allProfesores = repository.findAll();
        return ResponseEntity.ok(allProfesores);
    }

    @PostMapping
    public ResponseEntity registerProfessores(@RequestBody @Valid RequestProfessores professoresDTO){
        Professores newProf = new Professores(professoresDTO);
        repository.save(newProf);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProfessor(@RequestBody @Valid RequestProfessores professoresDTO){
        Optional<Professores> optionalProfessores = repository.findById(professoresDTO.id());
        if(optionalProfessores.isPresent()){
            Professores professores = optionalProfessores.get();
            professores.setNome(professoresDTO.nome());
            professores.setMateria(professoresDTO.materia());
            professores.setSalarioInCents(professoresDTO.salarioincents());
            return ResponseEntity.ok(professores);
        } else{
            throw  new EntityNotFoundException();
        }
    }
}
