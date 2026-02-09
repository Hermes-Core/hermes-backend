# 🦉 Hermes: Vida Escolar em Tempo Real

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![Badge Java](https://img.shields.io/static/v1?label=JAVA&message=17&color=blue&style=for-the-badge&logo=java)
![Badge Spring Boot](https://img.shields.io/static/v1?label=SPRING-BOOT&message=4.X&color=green&style=for-the-badge&logo=spring)

> Projeto Integrado II - Equipe Hermes (UFCA/Várzea Alegre)

## 📑 Tabela de Conteúdos
* [Sobre o Projeto](#-sobre-o-projeto)
* [Funcionalidades](#-funcionalidades)
* [Arquitetura e POO](#-arquitetura-e-poo-implementação-acadêmica)
* [Impacto Social](#-possíveis-usos-da-nossa-solução-componente-extensionista)
* [Tecnologias](#-tecnologias-utilizadas)
* [Modelagem de Dados](#-modelagem-de-dados-der)
* [Como Rodar](#-como-rodar-o-projeto)
* [Equipe](#-autores)

---

## 💻 Sobre o Projeto

O **Hermes** é uma solução multiplataforma (Web e Mobile) desenvolvida para resolver a **falha de comunicação entre escolas e pais/responsáveis**.

Atualmente, a dependência de métodos ultrapassados, como agendas físicas, gera um fluxo de informações tardio e inseguro. O Hermes atua como uma central de controle, permitindo o acompanhamento da vida escolar em tempo real, desde a frequência até o desempenho acadêmico.

---

## 🚀 Funcionalidades

O sistema atende a dois perfis principais de usuários, conforme definido nos Casos de Uso da Sprint 3:

### 📱 Para Pais e Responsáveis (App)
- **Agenda Digital:** Visualização diária de tarefas de casa e atividades de classe.
- **Monitoramento de Desempenho:** Acesso a notas (AP1, AP2, Média) e histórico de evolução.
- **Agendamento de Atendimentos:** Solicitação de reuniões presenciais com professores ou gestão.
- **Notificações:** Recebimento de avisos e comunicados da escola em tempo real.
- **Calendário Letivo:** Consulta de feriados, provas e eventos.

### 🏫 Para a Escola (Web - Gestão)
- **Gerenciamento Acadêmico:** Cadastro de Turmas, Disciplinas e Usuários (Secretaria).
- **Lançamento de Dados:** Professores lançam notas, faltas e atividades na plataforma.
- **Comunicação:** Envio de avisos para turmas específicas ou para toda a escola.

---

## ☕ Arquitetura e POO (Implementação Acadêmica)

Este projeto está sendo desenvolvido utilizando **Java com Spring Boot**, adotando os princípios da **Orientação a Objetos** para mapear o mundo real escolar para o software. Abaixo, detalhamos como os requisitos da disciplina foram atendidos:

### 1. Herança e Polimorfismo
Baseado no DER da Sprint 3, identificamos que Alunos, Professores e Funcionários compartilham dados. Criamos uma superclasse `Usuario`, e utilizamos a estratégia de herança (`@Inheritance(strategy = InheritanceType.JOINED)`).
* **Código:** As classes `Professor` e `Funcionario` estendem `Usuario`, reaproveitando atributos como `nome`, `email` e `senha`.

### 2. Encapsulamento
Todos os atributos das entidades (`Aluno`, `Turma`, `Nota`) são privados (`private`). O acesso é controlado exclusivamente via métodos Getters e Setters (utilizando **Lombok** para reduzir verbosidade), garantindo a integridade dos dados.

### 3. Abstração e Camadas
O projeto segue a arquitetura em camadas (Layered Architecture):
* **Model:** Representação das tabelas do banco (JPA Entities).
* **Repository:** Abstração do acesso a dados (Interfaces `JpaRepository`).
* **Service:** Regras de negócio isoladas dos controladores.
* **Controller:** Exposição dos endpoints REST.

---

## 🌍 Possíveis usos da nossa solução (Componente Extensionista)

O projeto **Hermes** transcende o ambiente acadêmico, apresentando potencial real para modernizar a educação básica em escolas públicas e privadas. Abaixo, listamos como a solução impacta o mundo real:

1.  **Inclusão de Famílias com Rotinas Intensas**
    * Em um cenário onde o tempo é escasso, muitos pais não conseguem ir à escola. O aplicativo permite que pais que trabalham longe acompanhem a frequência e o comportamento dos filhos em tempo real, garantindo a presença familiar mesmo à distância.

2.  **Combate à Evasão e Queda de Rendimento**
    * Substituindo agendas de papel, o Hermes permite intervenções pedagógicas precoces. Pais informados rapidamente sobre notas baixas ou faltas podem agir antes que o aluno reprove, promovendo o sucesso escolar

3.  **Modernização da Gestão Escolar**
    * Para a escola, a solução elimina processos manuais e burocráticos, otimizando o tempo dos professores e centralizando informações financeiras e acadêmicas em um só lugar.

---

## 🛠 Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.3 (Web, Data JPA, Validation)
* **Banco de Dados:** PostgreSQL
* **Ferramentas:** Docker, Maven, Git
* **IDE Sugerida:** IntelliJ IDEA ou VS Code

---

## 🗂 Modelagem de Dados (DER)

O banco de dados foi estruturado na Sprint 3 para suportar relacionamentos complexos:
* **1:N (Um para Muitos):** Uma `Turma` tem muitos `Alunos` 
* **N:N (Muitos para Muitos):** Resolvido através da entidade associativa de `Atividades` e `Notas` vinculadas a Aluno e Disciplina.

---

## ▶️ Como Rodar o Projeto

### Pré-requisitos
* Java 17 instalado
* Maven

### Passo a Passo

   ```bash
   git clone https://github.com/Hermes-Core/hermes-backend.git
   ```
   ```bash
   cd hermes-backend
   ```

   ```bash
   mvn clean install
   ```

   ```bash
   mvn spring-boot:run
   ```
