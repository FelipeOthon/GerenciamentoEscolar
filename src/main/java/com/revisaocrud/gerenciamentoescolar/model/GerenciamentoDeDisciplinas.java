package com.revisaocrud.gerenciamentoescolar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoDeDisciplinas {
    private final List<Disciplina> disciplinas = new ArrayList<>();
    private final Scanner scanner;

    public GerenciamentoDeDisciplinas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void gerenciarDisciplinas() {
        boolean voltar = false;
        while (!voltar) {
            exibirSubMenuDisciplinas();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1:
                    adicionarDisciplina();
                    break;
                case 2:
                    listarDisciplinas();
                    break;
                case 3:
                    buscarDisciplinaPorCodigo();
                    break;
                case 4:
                    atualizarDisciplina();
                    break;
                case 5:
                    removerDisciplina();
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

    private void exibirSubMenuDisciplinas() {
        System.out.println("\nGerenciamento de Disciplinas:");
        System.out.println("1. Adicionar Disciplina - Insira uma nova disciplina.");
        System.out.println("2. Listar Disciplinas - Veja todas as disciplinas cadastradas.");
        System.out.println("3. Buscar Disciplina por Código - Encontre uma disciplina pelo código.");
        System.out.println("4. Atualizar Disciplina - Altere os detalhes de uma disciplina existente.");
        System.out.println("5. Remover Disciplina - Exclua uma disciplina existente.");
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

    private void adicionarDisciplina() {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.nextLine();
        disciplinas.add(new Disciplina(nome, codigo));
        System.out.println("Disciplina \"" + nome + "\" com código \"" + codigo + "\" adicionada com sucesso!");
    }

    private void listarDisciplinas() {
        System.out.println("Disciplinas cadastradas:");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina d : disciplinas) {
                System.out.println(d);
            }
        }
    }

    private void buscarDisciplinaPorCodigo() {
        System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            System.out.println("Disciplina encontrada: " + disciplina);
        } else {
            System.out.println("Disciplina com código \"" + codigo + "\" não encontrada.");
        }
    }

    private void atualizarDisciplina() {
        System.out.print("Digite o código da disciplina a ser atualizada: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            System.out.print("Digite o novo nome da disciplina: ");
            String nome = scanner.nextLine();
            disciplina.setNome(nome);
            System.out.println("Disciplina atualizada com sucesso!");
        } else {
            System.out.println("Disciplina com código \"" + codigo + "\" não encontrada.");
        }
    }

    private void removerDisciplina() {
        System.out.print("Digite o código da disciplina a ser removida: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            disciplinas.remove(disciplina);
            System.out.println("Disciplina \"" + disciplina.getNome() + "\" com código \"" + codigo + "\" removida com sucesso!");
        } else {
            System.out.println("Disciplina com código \"" + codigo + "\" não encontrada.");
        }
    }

    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }
}
