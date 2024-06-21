package com.example.crud.dolmain.aluno;

public record RequestAluno(

        String id,

        String nome,

        Integer idade,

        String turma,

        String cidade
) {
}
