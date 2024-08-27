package com.revisaocrud;

import com.revisaocrud.gerenciamentoescolar.model.Aluno;
import com.revisaocrud.gerenciamentoescolar.model.Disciplina;
import com.revisaocrud.gerenciamentoescolar.model.Turma;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoEscolar {
    private static final List<Disciplina> disciplinas = new ArrayList<>();
    private static final List<Turma> turmas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1:
                    gerenciarDisciplinas();
                    break;
                case 2:
                    gerenciarTurmas();
                    break;
                case 3:
                    gerenciarAlunos();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento Escolar!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Gerenciar Disciplinas");
        System.out.println("2. Gerenciar Turmas");
        System.out.println("3. Gerenciar Alunos");
        System.out.println("4. Sair");
    }

    private static void exibirSubMenuDisciplinas() {
        System.out.println("Gerenciamento de Disciplinas:");
        System.out.println("1. Adicionar Disciplina");
        System.out.println("2. Listar Disciplinas");
        System.out.println("3. Atualizar Disciplina");
        System.out.println("4. Remover Disciplina");
        System.out.println("5. Voltar ao Menu Principal");
    }

    private static void exibirSubMenuTurmas() {
        System.out.println("Gerenciamento de Turmas:");
        System.out.println("1. Adicionar Turma");
        System.out.println("2. Listar Turmas");
        System.out.println("3. Buscar Turma por Código");
        System.out.println("4. Atualizar Turma");
        System.out.println("5. Remover Turma");
        System.out.println("6. Voltar ao Menu Principal");
    }

    private static void exibirSubMenuAlunos() {
        System.out.println("Gerenciamento de Alunos:");
        System.out.println("1. Adicionar Aluno");
        System.out.println("2. Listar Alunos");
        System.out.println("3. Buscar Aluno por Matrícula");
        System.out.println("4. Atualizar Aluno");
        System.out.println("5. Remover Aluno");
        System.out.println("6. Listar Alunos de uma Turma Específica"); // Nova opção
        System.out.println("7. Voltar ao Menu Principal");
    }

    private static int obterOpcao() {
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

    private static void gerenciarDisciplinas() {
        boolean voltar = false;
        while (!voltar) {
            exibirSubMenuDisciplinas();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1: adicionarDisciplina(); break;
                case 2: listarDisciplinas(); break;
                case 3: atualizarDisciplina(); break;
                case 4: removerDisciplina(); break;
                case 5: voltar = true; break;
                default: System.out.println("Opção inválida. Tente novamente."); break;
            }
        }
    }

    private static void gerenciarTurmas() {
        boolean voltar = false;
        while (!voltar) {
            exibirSubMenuTurmas();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1: adicionarTurma(); break;
                case 2: listarTurmas(); break;
                case 3: buscarTurmaPorCodigo(); break;
                case 4: atualizarTurma(); break;
                case 5: removerTurma(); break;
                case 6: voltar = true; break;
                default: System.out.println("Opção inválida. Tente novamente."); break;
            }
        }
    }

    private static void gerenciarAlunos() {
        boolean voltar = false;
        while (!voltar) {
            exibirSubMenuAlunos();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1: adicionarAluno(); break;
                case 2: listarAlunos(); break;
                case 3: buscarAlunoPorMatricula(); break;
                case 4: atualizarAluno(); break;
                case 5: removerAluno(); break;
                case 6: listarAlunosDaTurma(); break; // Nova opção
                case 7: voltar = true; break;
                default: System.out.println("Opção inválida. Tente novamente."); break;
            }
        }
    }

    private static void adicionarDisciplina() {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.nextLine();
        disciplinas.add(new Disciplina(nome, codigo));
        System.out.println("Disciplina adicionada com sucesso!");
    }

    private static void listarDisciplinas() {
        System.out.println("Disciplinas cadastradas:");
        for (Disciplina d : disciplinas) {
            System.out.println(d);
        }
    }

    private static void atualizarDisciplina() {
        System.out.print("Digite o código da disciplina a ser atualizada: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            System.out.print("Digite o novo nome da disciplina: ");
            String nome = scanner.nextLine();
            disciplina.setNome(nome);
            System.out.println("Disciplina atualizada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void removerDisciplina() {
        System.out.print("Digite o código da disciplina a ser removida: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            disciplinas.remove(disciplina);
            System.out.println("Disciplina removida com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void adicionarTurma() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o código da disciplina associada: ");
        String codigoDisciplina = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina != null) {
            turmas.add(new Turma(codigo, disciplina));
            System.out.println("Turma adicionada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void listarTurmas() {
        System.out.println("Turmas cadastradas:");
        for (Turma t : turmas) {
            System.out.println(t);
        }
    }

    private static void buscarTurmaPorCodigo() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            System.out.println("Turma encontrada: " + turma);
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void atualizarTurma() {
        System.out.print("Digite o código da turma a ser atualizada: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            System.out.print("Digite o novo código da disciplina associada: ");
            String codigoDisciplina = scanner.nextLine();
            Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
            if (disciplina != null) {
                turma.setDisciplina(disciplina);
                System.out.println("Turma atualizada com sucesso!");
            } else {
                System.out.println("Disciplina não encontrada.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void removerTurma() {
        System.out.print("Digite o código da turma a ser removida: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            turmas.remove(turma);
            System.out.println("Turma removida com sucesso!");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void adicionarAluno() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a matrícula do aluno: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            Aluno aluno = new Aluno(nome, matricula);
            turma.adicionarAluno(aluno);
            System.out.println("Aluno adicionado com sucesso!");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void listarAlunos() {
        System.out.println("Alunos cadastrados:");
        for (Turma t : turmas) {
            System.out.println("Turma: " + t.getCodigo() + " - Disciplina: " + t.getDisciplina().getNome());
            for (Aluno a : t.getAlunos()) {
                System.out.println(a);
            }
        }
    }

    private static void buscarAlunoPorMatricula() {
        System.out.print("Digite a matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        for (Turma t : turmas) {
            for (Aluno a : t.getAlunos()) {
                if (a.getMatricula() == matricula) {
                    System.out.println("Aluno encontrado: " + a);
                    return;
                }
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void atualizarAluno() {
        System.out.print("Digite a matrícula do aluno a ser atualizado: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        for (Turma t : turmas) {
            for (Aluno a : t.getAlunos()) {
                if (a.getMatricula() == matricula) {
                    System.out.print("Digite o novo nome do aluno: ");
                    String nome = scanner.nextLine();
                    a.setNome(nome);
                    System.out.println("Aluno atualizado com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Aluno não encontrado.");
    }
    private static void listarAlunosDaTurma() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            List<Aluno> alunos = turma.getAlunos();
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno cadastrado para esta turma.");
            } else {
                System.out.println("Alunos da turma " + codigoTurma + ":");
                for (Aluno aluno : alunos) {
                    System.out.println(aluno);
                }
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
    private static void removerAluno() {
        System.out.print("Digite a matrícula do aluno a ser removido: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        for (Turma t : turmas) {
            Aluno alunoARemover = t.buscarAlunoPorMatricula(matricula);
            if (alunoARemover != null) {
                t.removerAluno(matricula);
                System.out.println("Aluno removido com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }

    private static Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                return t;
            }
        }
        return null;
    }
}
