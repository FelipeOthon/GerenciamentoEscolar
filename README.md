# Sistema de Gerenciamento Escolar

## Descrição

O **Sistema de Gerenciamento Escolar** é uma aplicação de console para gerenciar disciplinas, turmas e alunos em um ambiente escolar. Ele oferece funcionalidades para adicionar, listar, buscar, atualizar e remover disciplinas, turmas e alunos, além de listar alunos por turma.

## Funcionalidades

### Gerenciamento de Disciplinas

- **Adicionar Disciplina**: Permite adicionar uma nova disciplina com nome e código.
- **Listar Disciplinas**: Exibe todas as disciplinas cadastradas.
- **Buscar Disciplina por Código**: Encontra uma disciplina específica pelo código fornecido.
- **Atualizar Disciplina**: Altera o nome ou código de uma disciplina existente.
- **Remover Disciplina**: Remove uma disciplina do sistema.

### Gerenciamento de Turmas

- **Adicionar Turma**: Permite adicionar uma nova turma associada a uma disciplina existente.
- **Listar Turmas**: Exibe todas as turmas cadastradas, mostrando o código e a disciplina associada.
- **Buscar Turma por Código**: Encontra uma turma específica pelo código fornecido.
- **Atualizar Turma**: Atualiza o código ou a disciplina associada a uma turma existente.
- **Remover Turma**: Remove uma turma do sistema.

### Gerenciamento de Alunos

- **Adicionar Aluno**: Permite adicionar um novo aluno com nome, matrícula e turma associada.
- **Listar Alunos**: Exibe todos os alunos cadastrados, mostrando nome, matrícula e turma.
- **Buscar Aluno por Matrícula**: Encontra um aluno específico pela matrícula fornecida.
- **Atualizar Aluno**: Altera o nome ou a turma associada a um aluno existente.
- **Remover Aluno**: Remove um aluno do sistema.
- **Listar Alunos por Turma**: Exibe todos os alunos associados a uma turma específica, incluindo o nome da disciplina da turma.

## Estrutura do Projeto

### Pacote `com.revisaocrud.gerenciamentoescolar.model`

- **Aluno.java**: Representa um aluno com nome, matrícula e turma associada.
- **Disciplina.java**: Representa uma disciplina com nome e código.
- **Turma.java**: Representa uma turma com código e disciplina associada.
- **GerenciamentoDeAlunos.java**: Gerencia operações relacionadas a alunos.
- **GerenciamentoDeDisciplinas.java**: Gerencia operações relacionadas a disciplinas.
- **GerenciamentoDeTurmas.java**: Gerencia operações relacionadas a turmas.

### Pacote `com.revisaocrud`

- **SistemaGerenciamentoEscolar.java**: Classe principal que inicia o sistema e gerencia o menu de navegação.

## Instruções de Uso

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

## Observações

- Certifique-se de que todos os arquivos Java estejam no mesmo diretório de pacotes conforme a estrutura do projeto.
- A aplicação é executada em modo console e requer a interação do usuário para entrada de dados.

