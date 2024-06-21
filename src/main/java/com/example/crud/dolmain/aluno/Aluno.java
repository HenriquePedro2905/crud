package com.example.crud.dolmain.aluno;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "alunos")
@Entity(name = "alunos")
@EqualsAndHashCode(of = "id")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private Integer idade;

    private String turma;

    private String cidade;

    public Aluno(RequestAluno requestAluno) {
        this.id = requestAluno.id();
        this.nome = requestAluno.nome();
        this.idade = requestAluno.idade();
        this.turma = requestAluno.turma();
        this.cidade = requestAluno.cidade();
    }


}
