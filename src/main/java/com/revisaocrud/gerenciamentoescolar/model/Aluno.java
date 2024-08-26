package com.revisaocrud.gerenciamentoescolar.model;

public class Aluno {
    private String nome;
    private int matricula;
    private String email;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno [Nome=" + nome + ", Matrícula=" + matricula + ", Email=" + email + "]";
    }
}