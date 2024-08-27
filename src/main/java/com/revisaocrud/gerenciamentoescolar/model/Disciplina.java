package com.revisaocrud.gerenciamentoescolar.model;

public class Disciplina {
    private String nome;
    private String codigo;

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Disciplina [Nome=" + nome + ", Código=" + codigo + "]";
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
}