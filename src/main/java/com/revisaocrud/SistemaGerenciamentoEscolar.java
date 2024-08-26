package com.revisaocrud;

import com.revisaocrud.gerenciamentoescolar.model.Aluno;
import com.revisaocrud.gerenciamentoescolar.model.Disciplina;
import com.revisaocrud.gerenciamentoescolar.model.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoEscolar {
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1: adicionarDisciplina(); break;
                case 2: listarDisciplinas(); break;
                case 3: atualizarDisciplina(); break;
                case 4: removerDisciplina(); break;
                case 5: adicionarTurma(); break;
                case 6: listarTurmas(); break;
                case 7: buscarTurmaPorCodigo(); break;
                case 8: atualizarTurma(); break;
                case 9: removerTurma(); break;
                case 10: adicionarAluno(); break;
                case 11: listarAlunos(); break;
                case 12: buscarAlunoPorMatricula(); break;
                case 13: atualizarAluno(); break;
                case 14: removerAluno(); break;
                case 15: continuar = false; break;
                default: System.out.println("Opção inválida. Tente novamente."); break;
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento Escolar!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar Disciplina");
        System.out.println("2. Listar Disciplinas");
        System.out.println("3. Atualizar Disciplina");
        System.out.println("4. Remover Disciplina");
        System.out.println("5. Adicionar Turma");
        System.out.println("6. Listar Turmas");
        System.out.println("7. Buscar Turma por Código");
        System.out.println("8. Atualizar Turma");
        System.out.println("9. Remover Turma");
        System.out.println("10. Adicionar Aluno");
        System.out.println("11. Listar Alunos");
        System.out.println("12. Buscar Aluno por Matrícula");
        System.out.println("13. Atualizar Aluno");
        System.out.println("14. Remover Aluno");
        System.out.println("15. Sair");
    }

    private static int obterOpcao() {
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }

    private static void adicionarDisciplina() {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.next();
        System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.next();
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
        String codigo = scanner.next();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            System.out.print("Digite o novo nome da disciplina: ");
            String nome = scanner.next();
            disciplina.setNome(nome);
            System.out.println("Disciplina atualizada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void removerDisciplina() {
        System.out.print("Digite o código da disciplina a ser removida: ");
        String codigo = scanner.next();
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
        String codigo = scanner.next();
        System.out.print("Digite o código da disciplina associada: ");
        String codigoDisciplina = scanner.next();
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
        String codigo = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            System.out.println("Turma encontrada: " + turma);
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void atualizarTurma() {
        System.out.print("Digite o código da turma a ser atualizada: ");
        String codigo = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            System.out.print("Digite o novo código da disciplina associada: ");
            String codigoDisciplina = scanner.next();
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
        String codigo = scanner.next();
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
        String codigoTurma = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.next();
            System.out.print("Digite a matrícula do aluno: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Digite o email do aluno: ");
            String email = scanner.nextLine();
            Aluno aluno = new Aluno(nome, matricula, email);
            turma.adicionarAluno(aluno);
            System.out.println("Aluno adicionado com sucesso!");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void listarAlunos() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.println("Alunos na turma " + turma.getCodigo() + ":");
            for (Aluno aluno : turma.listarAlunos()) {
                System.out.println(aluno);
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void buscarAlunoPorMatricula() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.print("Digite a matrícula do aluno: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            Aluno aluno = turma.buscarAlunoPorMatricula(matricula);
            if (aluno != null) {
                System.out.println("Aluno encontrado: " + aluno);
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void atualizarAluno() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.print("Digite a matrícula do aluno a ser atualizado: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            Aluno aluno = turma.buscarAlunoPorMatricula(matricula);
            if (aluno != null) {
                System.out.print("Digite o novo nome do aluno: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o novo email do aluno: ");
                String email = scanner.nextLine();
                aluno.setNome(nome);
                aluno.setEmail(email);
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void removerAluno() {
        System.out.print("Digite o código da turma: ");
        String codigoTurma = scanner.next();
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        if (turma != null) {
            System.out.print("Digite a matrícula do aluno a ser removido: ");
            int matricula = scanner.nextInt();
            turma.removerAluno(matricula);
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    // Métodos auxiliares para buscar disciplinas e turmas por código
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

