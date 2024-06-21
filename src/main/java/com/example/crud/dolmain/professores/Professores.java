package com.example.crud.dolmain.professores;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "professores")
@Entity(name = "professores")
@EqualsAndHashCode(of = "id")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Professores {
    
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private String materia;

    @Column(name = "salarioincents")
    private Integer salarioInCents;


    public Professores(RequestProfessores requestProfessores) {
        this.nome = requestProfessores.nome();
        this.materia = requestProfessores.materia();
        this.salarioInCents = requestProfessores.salarioincents();
    }

}
