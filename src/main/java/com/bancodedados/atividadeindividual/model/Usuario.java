package com.bancodedados.atividadeindividual.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    private String cpf;
    private String nome;
    private LocalDate dataAniversario;

    public Usuario(){}

    public Usuario(String cpf, String nome, LocalDate dataAniversario) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataAniversario = dataAniversario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
