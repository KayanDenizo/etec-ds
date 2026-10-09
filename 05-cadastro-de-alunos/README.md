# 🎓 Cadastro de Alunos (Java Swing)

Sistema desktop em Java Swing para cadastrar alunos em um banco MySQL, usando o padrão DAO.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

## Funcionalidades

- Cadastro com nome, e-mail, curso, gênero e endereço
- Preferências de recebimento de e-mail e notificações
- Persistência no MySQL via JDBC (`AlunoDAO`)

## Como rodar

1. Crie o banco `cadastro` no MySQL, com a tabela de alunos
2. Ajuste usuário e senha em `src/Conexao.java`
3. Adicione o [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) ao classpath
4. Execute `src/Main.java` (pelo IntelliJ IDEA, por exemplo)

---

Feito por [Kayan Denizo](https://github.com/KayanDenizo).
