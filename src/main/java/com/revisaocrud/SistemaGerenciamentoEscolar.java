package com.revisaocrud;

import com.revisaocrud.gerenciamentoescolar.model.GerenciamentoDeAlunos;
import com.revisaocrud.gerenciamentoescolar.model.GerenciamentoDeDisciplinas;
import com.revisaocrud.gerenciamentoescolar.model.GerenciamentoDeTurmas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaGerenciamentoEscolar {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        GerenciamentoDeDisciplinas gerenciamentoDeDisciplinas = new GerenciamentoDeDisciplinas(scanner);
        GerenciamentoDeTurmas gerenciamentoDeTurmas = new GerenciamentoDeTurmas(scanner, gerenciamentoDeDisciplinas);
        GerenciamentoDeAlunos gerenciamentoDeAlunos = new GerenciamentoDeAlunos(scanner, gerenciamentoDeTurmas);

        while (continuar) {
            exibirMenu();
            int opcao = obterOpcao(scanner);
            switch (opcao) {
                case 1:
                    gerenciamentoDeDisciplinas.gerenciarDisciplinas();
                    break;
                case 2:
                    gerenciamentoDeTurmas.gerenciarTurmas();
                    break;
                case 3:
                    gerenciamentoDeAlunos.gerenciarAlunos();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nBem-vindo ao Sistema de Gerenciamento Escolar!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Gerenciar Disciplinas");
        System.out.println("2. Gerenciar Turmas");
        System.out.println("3. Gerenciar Alunos");
        System.out.println("4. Sair");
    }

    private static int obterOpcao(Scanner scanner) {
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
}
