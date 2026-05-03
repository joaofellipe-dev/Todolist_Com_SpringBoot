📝 To-Do List API (Spring Boot)

Este foi o meu primeiro projeto utilizando Spring Boot, desenvolvido com o objetivo de colocar em prática conceitos fundamentais de desenvolvimento backend com Java. A aplicação consiste em uma API REST de gerenciamento de tarefas (To-Do List), permitindo a criação e organização de atividades de forma simples e eficiente.

Neste projeto, utilizei Java com Spring Boot, Spring Data JPA para persistência de dados, e o H2 Database em memória, que facilita o desenvolvimento por não exigir instalação de um banco de dados externo. Também implementei criptografia de senhas utilizando BCrypt, garantindo maior segurança no armazenamento de dados dos usuários.

A API permite o cadastro de usuários, criação de tarefas e associação dessas tarefas a um usuário específico. Além disso, foram implementadas validações, como a verificação de datas para impedir a criação de tarefas com datas no passado. Também utilizei filtros para interceptar requisições, simulando um controle básico de autenticação.

O banco de dados H2 é executado em memória, o que torna a aplicação leve e rápida, sendo ideal para testes e aprendizado. Durante a execução da aplicação, é possível acessar o console do H2 diretamente pelo navegador.

Para executar o projeto, basta clonar o repositório, acessar a pasta do projeto e rodar a aplicação utilizando Maven ou diretamente pela IDE, como o IntelliJ.

Durante o desenvolvimento deste projeto, consegui aprender e praticar conceitos importantes como a criação de APIs REST, injeção de dependências, uso de entidades com JPA, manipulação de datas com LocalDateTime e estruturação básica de um backend com Spring Boot.

Como próximos passos, pretendo evoluir este projeto implementando autenticação com JWT, adicionando testes automatizados, utilizando um banco de dados persistente como PostgreSQL e documentando a API com Swagger.

Desenvolvido por João Fellipe.
