package com.revisaocrud.gerenciamentoescolar.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private List<Aluno> alunos;

    public Turma(String codigo, Disciplina disciplina) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int matricula) {
        Aluno alunoARemover = buscarAlunoPorMatricula(matricula);
        if (alunoARemover != null) {
            alunos.remove(alunoARemover);
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Turma [Código=" + codigo + ", Disciplina=" + disciplina + "]";
    }

    public void setDisciplina(Disciplina novaDisciplina) {
    }

    public Object getCodigo() {
        return null;
    }

    public Aluno[] getAlunos() {
        return new Aluno[0];
    }

    public Aluno getDisciplina() {
        return null;
    }
}
