package com.revisaocrud.gerenciamentoescolar.model;

public class Aluno {
    private String nome;
    private String matricula;
    private Turma turma;

    public Aluno(String nome, String matricula, Turma turma) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " (Matrícula: " + matricula + ") - Turma: " + turma.getCodigo();
    }
}
