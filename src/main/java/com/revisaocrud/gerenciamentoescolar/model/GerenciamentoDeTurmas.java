package com.revisaocrud.gerenciamentoescolar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoDeTurmas {
    private final List<Turma> turmas = new ArrayList<>();
    private final Scanner scanner;
    private final GerenciamentoDeDisciplinas gerenciamentoDeDisciplinas;

    public GerenciamentoDeTurmas(Scanner scanner, GerenciamentoDeDisciplinas gerenciamentoDeDisciplinas) {
        this.scanner = scanner;
        this.gerenciamentoDeDisciplinas = gerenciamentoDeDisciplinas;
    }

    public void gerenciarTurmas() {
        boolean voltar = false;
        while (!voltar) {
            exibirSubMenuTurmas();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1:
                    adicionarTurma();
                    break;
                case 2:
                    listarTurmas();
                    break;
                case 3:
                    buscarTurmaPorCodigo();
                    break;
                case 4:
                    atualizarTurma();
                    break;
                case 5:
                    removerTurma();
                    break;
                case 6:
                    voltar = true;
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void exibirSubMenuTurmas() {
        System.out.println("\nGerenciamento de Turmas:");
        System.out.println("1. Adicionar Turma - Insira uma nova turma.");
        System.out.println("2. Listar Turmas - Veja todas as turmas cadastradas.");
        System.out.println("3. Buscar Turma por Código - Encontre uma turma pelo código.");
        System.out.println("4. Atualizar Turma - Altere os detalhes de uma turma existente.");
        System.out.println("5. Remover Turma - Exclua uma turma existente.");
        System.out.println("6. Voltar ao Menu Principal - Retorne ao menu principal.");
    }

    private int obterOpcao() {
        int opcao = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
            }
        }
        return opcao;
    }

    private void adicionarTurma() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o código da disciplina associada: ");
        String codigoDisciplina = scanner.nextLine();
        Disciplina disciplina = gerenciamentoDeDisciplinas.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina != null) {
            turmas.add(new Turma(codigo, disciplina));
            System.out.println("Turma com código \"" + codigo + "\" adicionada com sucesso!");
        } else {
            System.out.println("Disciplina com código \"" + codigoDisciplina + "\" não encontrada.");
        }
    }

    private void listarTurmas() {
        System.out.println("Turmas cadastradas:");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma t : turmas) {
                System.out.println(t);
            }
        }
    }

    private void buscarTurmaPorCodigo() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            System.out.println("Turma encontrada: " + turma);
        } else {
            System.out.println("Turma com código \"" + codigo + "\" não encontrada.");
        }
    }

    private void atualizarTurma() {
        System.out.print("Digite o código da turma a ser atualizado: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            System.out.print("Digite o novo código da turma: ");
            String novoCodigo = scanner.nextLine();
            System.out.print("Digite o novo código da disciplina associada: ");
            String codigoDisciplina = scanner.nextLine();
            Disciplina disciplina = gerenciamentoDeDisciplinas.buscarDisciplinaPorCodigo(codigoDisciplina);
            if (disciplina != null) {
                turma.setCodigo(novoCodigo);
                turma.setDisciplina(disciplina);
                System.out.println("Turma atualizada com sucesso!");
            } else {
                System.out.println("Disciplina com código \"" + codigoDisciplina + "\" não encontrada.");
            }
        } else {
            System.out.println("Turma com código \"" + codigo + "\" não encontrada.");
        }
    }

    private void removerTurma() {
        System.out.print("Digite o código da turma a ser removida: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            turmas.remove(turma);
            System.out.println("Turma com código \"" + codigo + "\" removida com sucesso!");
        } else {
            System.out.println("Turma com código \"" + codigo + "\" não encontrada.");
        }
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                return t;
            }
        }
        return null;
    }
}
