# 🦉 Hermes: Vida Escolar em Tempo Real

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![Badge Java](https://img.shields.io/static/v1?label=JAVA&message=17&color=blue&style=for-the-badge&logo=java)
![Badge Spring Boot](https://img.shields.io/static/v1?label=SPRING-BOOT&message=4.X&color=green&style=for-the-badge&logo=spring)

> Projeto Integrado II - Equipe Hermes (UFCA/Várzea Alegre)

## 📑 Tabela de Conteúdos
* [Sobre o Projeto](#-sobre-o-projeto)
* [Funcionalidades](#-funcionalidades)
* [Arquitetura e POO](#-arquitetura-e-poo-implementação-acadêmica)
* [Arquitetura de Informação e Prototipagem](#-arquitetura-de-informação-e-prototipagem)
* [Princípios de IHC Aplicados](#-princípios-de-ihc-aplicados)
* [Acessibilidade e Design Inclusivo](#-acessibilidade-e-design-inclusivo)
* [Impacto Social](#-impacto-social-componente-extensionista)
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

## 🎲 Projeto Físico de Banco de Dados
O **Projeto Físico** é a etapa técnica onde transformamos os diagramas visuais e modelos teóricos (como o DER) em comandos reais que o sistema gerenciador de banco de dados (SGBD) pode executar. É neste momento que definimos a estrutura exata de como os dados serão armazenados no servidor.

Enquanto a modelagem conceitual foca no "o quê" (quais informações precisamos?), o projeto físico define o "como" (de que forma vamos guardar isso?).

**Por que isso é fundamental para quem estuda programação?**

1.  **Integridade e Segurança:** É no projeto físico que criamos regras rígidas (restrições) para garantir a qualidade dos dados. Por exemplo: impedir que o sistema aceite uma nota escolar negativa ou bloquear o cadastro de dois usuários com o mesmo e-mail.

2.  **Desempenho (Performance):** Definir corretamente os tipos de dados (usar números inteiros para IDs, por exemplo) e criar índices faz com que o sistema responda instantaneamente, mesmo com um grande volume de informações.

3.  **Conexão com o Back-end:** Para um desenvolvedor (seja Java, Python ou Node.js), entender o banco de dados físico é essencial para escrever um código eficiente. O banco de dados é a base onde toda a lógica da aplicação se apoia para persistir as informações de forma duradoura.

<img width="6238" height="8192" alt="Gestão Escolar Notas Flow-2026-02-09-235419" src="https://github.com/user-attachments/assets/785cc6e7-6e75-4e53-a932-f23ebadbdb38" />

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

## 🗺️ IHC e Prototipagem

Na Sprint 3 (EP3), o projeto Hermes evoluiu para além do Back-end, incorporando uma **camada de experiência de usuário** estruturada e planejada. Agora, contamos com um **Sitemap** e **Wireframes** que traduzem os Casos de Uso (UC01 a UC12) em interfaces concretas, garantindo que a navegação seja intuitiva e eficiente.

### 📐 Sitemap Hierárquico
O **Sitemap** foi estruturado de forma hierárquica, seguindo os princípios da Arquitetura de Informação. Essa organização permite que o usuário encontre informações críticas (como notas, frequência e agendamentos) em **no máximo dois ou três cliques**, garantindo:

* **Eficiência na navegação:** Redução do tempo de busca por informações.
* **Clareza estrutural:** Divisão lógica entre módulos (Agenda, Desempenho, Atendimentos).
* **Escalabilidade:** Facilidade para adicionar novas funcionalidades sem comprometer a usabilidade.

### 🖼️ Layout Dashboard Web
O layout escolhido foi um **Dashboard Web com barra lateral fixa**, focado em manter a **consistência visual** em todos os módulos do sistema. Essa decisão de design:

* **Mantém o contexto:** O menu lateral sempre visível permite que o usuário saiba onde está e navegue rapidamente entre seções.
* **Padroniza a experiência:** Todos os módulos (Agenda, Desempenho, Atendimentos) seguem a mesma estrutura visual, reduzindo a curva de aprendizado.
* **Otimiza o espaço:** A área principal fica dedicada ao conteúdo relevante, sem distrações.

Essa estruturação visual não é arbitrária — ela reflete os **modelos mentais** dos usuários (pais e escolas), tornando o sistema natural e previsível.

---

## 🎨 Princípios de IHC Aplicados

O Hermes foi projetado com base nos **princípios fundamentais de Interação Humano-Computador (IHC)**, garantindo que a tecnologia se adapte ao usuário, e não o contrário.

### 1. Affordance e Modelos Mentais
A interface utiliza **ícones e componentes visuais** que remetem a objetos do mundo real escolar, facilitando o aprendizado intuitivo dos pais:

* **Calendário visual:** Para representar a agenda de tarefas e eventos, utilizamos um componente de calendário similar aos encontrados em aplicativos de agenda pessoal.
* **Boletim escolar digital:** A apresentação de notas segue o formato tradicional de boletins, facilitando a compreensão imediata.
* **Ícones reconhecíveis:** Utilizamos símbolos universais (📅 para agenda, 📊 para desempenho, 👤 para perfil) que dispensam explicações textuais.

Essa estratégia reduz a **carga cognitiva**, permitindo que usuários com diferentes níveis de literacia digital utilizem o sistema sem treinamento formal.

### 2. Visibilidade do Status do Sistema
O design garante que o usuário **sempre saiba em qual seção está** e receba **feedback visual sobre suas ações**:

* **Breadcrumbs (migalhas de pão):** Indicam o caminho de navegação atual.
* **Destaque visual no menu:** A seção ativa aparece com cor diferenciada.
* **Mensagens de confirmação:** Ao agendar um atendimento ou salvar uma informação, o sistema exibe um feedback imediato ("Agendamento confirmado com sucesso!").

Esse princípio, descrito por Jakob Nielsen como uma das **heurísticas de usabilidade**, evita que o usuário se sinta perdido ou inseguro durante a navegação.

---

## ♿ Acessibilidade e Design Inclusivo

O **compromisso social com a acessibilidade** é um pilar fundamental do Hermes. Reconhecemos que a educação é um direito universal, e a tecnologia deve remover barreiras, não criá-las.

### 🎯 Alto Contraste e Legibilidade
O sistema utiliza **alto contraste** entre texto e fundo, além de **fontes legíveis** (tamanho mínimo de 14px), para atender:

* **Usuários com baixa visão ou dificuldades visuais:** Facilitando a leitura sem auxílio de tecnologias assistivas.
* **Contextos de uso adversos:** Pais que acessam o sistema em ambientes externos, sob alta luminosidade, ou em situações de pressa.

### 🌐 Cidadania Digital e Inclusão
O **design inclusivo** não é apenas uma escolha técnica — é uma **prática de cidadania digital**. Ao projetar para todos, estamos:

* **Removendo barreiras tecnológicas:** Permitindo que pais com diferentes níveis de familiaridade com tecnologia utilizem o sistema.
* **Promovendo equidade:** Garantindo que informações escolares sejam acessíveis independentemente de condições socioeconômicas ou capacidades físicas.
* **Fortalecendo a inclusão educacional:** Famílias que antes eram excluídas do acompanhamento escolar por barreiras tecnológicas agora têm acesso facilitado.

Essa abordagem alinha o Hermes aos princípios da **Web Content Accessibility Guidelines (WCAG)** e reflete o compromisso da equipe com uma tecnologia que serve a todos.

---

## 🌍 Impacto Social (Componente Extensionista)

O projeto **Hermes** transcende o ambiente acadêmico, apresentando potencial real para modernizar a educação básica em escolas públicas e privadas. Ao adotar o **Design Centrado no Usuário (User-Centered Design - UCD)**, colocamos as necessidades dos pais e da comunidade escolar no centro de todas as decisões de projeto.

### 🧑‍🤝‍🧑 Design Centrado no Usuário (UCD)
O **User-Centered Design** não é apenas uma metodologia — é uma filosofia que transforma a forma como a tecnologia é concebida. Ao colocar as **necessidades reais dos pais** no centro do projeto, o Hermes deixa de ser um simples sistema e se torna uma **ferramenta de democratização da informação escolar**.

Na prática, isso significa:

* **Pesquisa com usuários reais:** As funcionalidades foram definidas a partir de entrevistas com pais, professores e gestores escolares, identificando dores reais (como a dificuldade de acompanhar a frequência ou a falta de transparência nas notas).
* **Iteração constante:** Os wireframes e protótipos foram validados com usuários antes da implementação, garantindo que a interface atenda às expectativas e limitações do público-alvo.
* **Foco na simplicidade:** Reconhecemos que muitos pais têm baixa literacia digital. Por isso, cada tela foi simplificada ao máximo, evitando jargões técnicos e priorizando a clareza.

Essa abordagem garante que o Hermes seja **efetivamente usado**, e não apenas desenvolvido.

### 🎯 Democratização da Informação Escolar
Ao colocar as necessidades dos pais no centro do projeto, o Hermes:

* **Combate a assimetria de informação:** Antes do Hermes, muitos pais só descobriam problemas acadêmicos dos filhos no final do bimestre, quando já era tarde demais. Agora, a informação flui em tempo real.
* **Fortalece o vínculo família-escola:** A transparência e a comunicação facilitada criam uma relação de confiança entre pais e instituição.
* **Reduz a evasão escolar:** Pais informados e engajados conseguem identificar sinais de desinteresse ou dificuldade, permitindo intervenções pedagógicas e familiares antes que o aluno abandone os estudos.

### 💡 Impactos Concretos no Mundo Real

1.  **Inclusão de Famílias com Rotinas Intensas**
    * Em um cenário onde o tempo é escasso, muitos pais não conseguem ir à escola. O aplicativo permite que pais que trabalham longe acompanhem a frequência e o comportamento dos filhos em tempo real, garantindo a presença familiar mesmo à distância.

2.  **Combate à Evasão e Queda de Rendimento**
    * Substituindo agendas de papel, o Hermes permite intervenções pedagógicas precoces. Pais informados rapidamente sobre notas baixas ou faltas podem agir antes que o aluno reprove, promovendo o sucesso escolar.

3.  **Modernização da Gestão Escolar**
    * Para a escola, a solução elimina processos manuais e burocráticos, otimizando o tempo dos professores e centralizando informações financeiras e acadêmicas em um só lugar.

Ao unir **tecnologia, design centrado no usuário e compromisso social**, o Hermes se consolida como uma ferramenta de transformação educacional, promovendo equidade e fortalecendo a relação entre família e escola.

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
