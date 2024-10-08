# 📚 Sistema de Gerenciamento Escolar

## 🎯 Descrição

O **Sistema de Gerenciamento Escolar** é uma aplicação de console desenvolvida para gerenciar de forma eficiente disciplinas, turmas e alunos em um ambiente escolar. Oferece funcionalidades completas para:

- Adicionar, listar, buscar, atualizar e remover disciplinas.
- Adicionar, listar, buscar, atualizar e remover turmas.
- Adicionar, listar, buscar, atualizar e remover alunos.
- Listar alunos por turma com detalhes da disciplina.

## ⚙️ Funcionalidades

### Gerenciamento de Disciplinas

- **Adicionar Disciplina**: Inclui novas disciplinas com nome e código.
- **Listar Disciplinas**: Mostra todas as disciplinas cadastradas.
- **Buscar Disciplina por Código**: Encontra uma disciplina específica pelo código.
- **Atualizar Disciplina**: Modifica o nome ou código de uma disciplina.
- **Remover Disciplina**: Exclui uma disciplina do sistema.

### Gerenciamento de Turmas

- **Adicionar Turma**: Adiciona novas turmas associadas a disciplinas.
- **Listar Turmas**: Mostra todas as turmas, incluindo código e disciplina.
- **Buscar Turma por Código**: Localiza uma turma específica pelo código.
- **Atualizar Turma**: Atualiza código ou disciplina de uma turma.
- **Remover Turma**: Remove uma turma do sistema.

### Gerenciamento de Alunos

- **Adicionar Aluno**: Adiciona um novo aluno com nome, matrícula e turma.
- **Listar Alunos**: Exibe todos os alunos cadastrados com detalhes.
- **Buscar Aluno por Matrícula**: Encontra um aluno específico pela matrícula.
- **Atualizar Aluno**: Modifica nome ou turma associada a um aluno.
- **Remover Aluno**: Exclui um aluno do sistema.
- **Listar Alunos por Turma**: Exibe alunos associados a uma turma, com detalhes da disciplina.

## 📂 Estrutura do Projeto

### Pacote `com.revisaocrud.gerenciamentoescolar.model`

- **`Aluno.java`**: Representa um aluno com nome, matrícula e turma associada.
- **`Disciplina.java`**: Representa uma disciplina com nome e código.
- **`Turma.java`**: Representa uma turma com código e disciplina associada.
- **`GerenciamentoDeAlunos.java`**: Gerencia operações relacionadas a alunos.
- **`GerenciamentoDeDisciplinas.java`**: Gerencia operações relacionadas a disciplinas.
- **`GerenciamentoDeTurmas.java`**: Gerencia operações relacionadas a turmas.

### Pacote `com.revisaocrud`

- **`SistemaGerenciamentoEscolar.java`**: Classe principal que inicia o sistema e gerencia o menu de navegação.

## 🚀 Instruções de Uso

1. **Compile o código fonte**:
    ```bash
    javac com/revisaocrud/gerenciamentoescolar/model/*.java
    javac com/revisaocrud/SistemaGerenciamentoEscolar.java
    ```

2. **Execute o sistema**:
    ```bash
    java com.revisaocrud.SistemaGerenciamentoEscolar
    ```

3. **Siga as instruções no console** para gerenciar disciplinas, turmas e alunos.

## 📝 Observações

- Certifique-se de que todos os arquivos Java estejam no diretório correto conforme a estrutura do projeto.
- A aplicação é executada em modo console e requer a interação do usuário para entrada de dados.

## 📄 Exemplo de Saída

Aqui está um exemplo de como o sistema exibe informações:

**Menu Principal**:

Bem-vindo ao Sistema de Gerenciamento Escolar! Escolha uma opção:

    Gerenciar Disciplinas
    Gerenciar Turmas
    Gerenciar Alunos
    Sair Digite a opção desejada:

