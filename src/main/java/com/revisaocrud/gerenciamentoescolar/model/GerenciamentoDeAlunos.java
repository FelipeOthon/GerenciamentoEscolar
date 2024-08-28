package com.revisaocrud.gerenciamentoescolar.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoDeAlunos {
    private final List<Aluno> alunos = new ArrayList<>();
    private final Scanner scanner;
    private final GerenciamentoDeTurmas gerenciamentoDeTurmas;

    public GerenciamentoDeAlunos(Scanner scanner, GerenciamentoDeTurmas gerenciamentoDeTurmas) {
        this.scanner = scanner;
        this.gerenciamentoDeTurmas = gerenciamentoDeTurmas;
    }

    public void gerenciarAlunos() {
        boolean voltar = false;
        while (!voltar) {
            exibirSubMenuAlunos();
            int opcao = obterOpcao(scanner);
            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    buscarAlunoPorMatricula();
                    break;
                case 4:
                    atualizarAluno();
                    break;
                case 5:
                    removerAluno();
                    break;
                case 6:
                    listarAlunosPorTurma();
                    break;
                case 7:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void exibirSubMenuAlunos() {
        System.out.println("Gerenciamento de Alunos:");
        System.out.println("1. Adicionar Aluno");
        System.out.println("2. Listar Alunos");
        System.out.println("3. Buscar Aluno por Matrícula");
        System.out.println("4. Atualizar Aluno");
        System.out.println("5. Remover Aluno");
        System.out.println("6. Listar Alunos por Turma");
        System.out.println("7. Voltar ao Menu Principal");
    }

    private void adicionarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite o código da turma do aluno: ");
        String codigoTurma = scanner.nextLine();
        Turma turma = gerenciamentoDeTurmas.buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            alunos.add(new Aluno(nome, matricula, turma));
            System.out.println("Aluno adicionado com sucesso!");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private void listarAlunos() {
        System.out.println("Alunos cadastrados:");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    private void buscarAlunoPorMatricula() {
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void atualizarAluno() {
        System.out.print("Digite a matrícula do aluno a ser atualizado: ");
        String matricula = scanner.nextLine();
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            System.out.print("Digite o novo nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o novo código da turma do aluno: ");
            String codigoTurma = scanner.nextLine();
            Turma turma = gerenciamentoDeTurmas.buscarTurmaPorCodigo(codigoTurma);
            if (turma != null) {
                aluno.setNome(nome);
                aluno.setTurma(turma);
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Turma não encontrada.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void removerAluno() {
        System.out.print("Digite a matrícula do aluno a ser removido: ");
        String matricula = scanner.nextLine();
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void listarAlunosPorTurma() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.nextLine();
        Turma turma = gerenciamentoDeTurmas.buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.println("Alunos da turma " + codigoTurma + " (" + turma.getDisciplina().getNome() + "):");
            for (Aluno a : alunos) {
                if (a.getTurma().equals(turma)) {
                    System.out.println("Aluno [Nome=" + a.getNome() + ", Matrícula=" + a.getMatricula() + "] - Turma " + turma.getCodigo() + " (" + turma.getDisciplina().getNome() + ")");
                }
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    private int obterOpcao(Scanner scanner) {
        int opcao = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();
                entradaValida = true; // Saímos do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        scanner.nextLine(); // Limpa o buffer após a entrada
        return opcao;
    }
}
