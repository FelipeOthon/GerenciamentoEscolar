package com.revisaocrud.gerenciamentoescolar.model;

public class Turma {
    private String codigo;
    private Disciplina disciplina;

    public Turma(String codigo, Disciplina disciplina) {
        this.codigo = codigo;
        this.disciplina = disciplina;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Turma: " + codigo + " - Disciplina: " + disciplina.getNome();
    }
}
