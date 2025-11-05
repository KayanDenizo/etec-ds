# Projeto Integrado - Sistema de Cadastro (Java Swing)

Aplicação desktop em Java Swing com:
- JFrame principal com barra de menus (Arquivo, Ajuda)
- Abas (JTabbedPane): "Clientes" e "Produtos"
- Formulários com campos de texto, checkbox, radio buttons, combo box
- Painéis organizadores
- Botões: Cadastrar, Limpar, Sair
- Caixas de diálogo de mensagem e confirmação

## Estrutura
```
src/
  br/com/pi/Main.java
  br/com/pi/ui/MainFrame.java
  br/com/pi/ui/ClientePanel.java
  br/com/pi/ui/ProdutoPanel.java
```

## Como compilar e executar (sem IDE)
Requisitos: JDK 8+ no PATH.

No Windows (cmd, PowerShell ou Git Bash) a partir da raiz do projeto:
```bash
# Compilar
javac -d out $(find src -name "*.java")

# Executar
java -cp out br.com.pi.Main
```

Caso o `find` não esteja disponível no seu shell, use:
```bash
# Compilar (Windows cmd/PowerShell)
javac -d out src\\br\\com\\pi\\Main.java src\\br\\com\\pi\\ui\\MainFrame.java src\\br\\com\\pi\\ui\\ClientePanel.java src\\br\\com\\pi\\ui\\ProdutoPanel.java

# Executar
java -cp out br.com.pi.Main
```

## Observações
- O botão "Sair" e o menu "Arquivo > Sair" solicitam confirmação antes de fechar.
- As ações "Cadastrar" exibem um resumo dos dados informados.

## Persistência em MySQL
Agora o sistema salva em MySQL usando JDBC.

1) Instale o driver MySQL (Connector/J):
- Baixe o `.jar` do Connector/J da Oracle/MySQL e coloque em uma pasta, por ex: `lib/mysql-connector-j.jar`.

2) Configure credenciais em `src/br/com/pi/db/DbConfig.java`:
```
public static String HOST = "localhost";
public static int PORT = 3306;
public static String DATABASE = "pi_cadastro";
public static String USER = "root";
public static String PASSWORD = "root";
```

3) Crie o banco e tabelas (execute no MySQL):
```sql
CREATE DATABASE IF NOT EXISTS pi_cadastro DEFAULT CHARACTER SET utf8mb4;
USE pi_cadastro;

CREATE TABLE IF NOT EXISTS clientes (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  email VARCHAR(180) NOT NULL,
  cpf VARCHAR(20) NOT NULL,
  sexo VARCHAR(20) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  newsletter TINYINT(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  codigo VARCHAR(60) NOT NULL,
  preco DECIMAL(10,2) NULL,
  categoria VARCHAR(60) NOT NULL,
  tipo VARCHAR(20) NOT NULL,
  disponivel TINYINT(1) NOT NULL
);
```

4) Compile incluindo o driver no classpath e execute:
- Git Bash:
```bash
javac -cp lib/mysql-connector-j.jar -d out $(find src -name "*.java")
java -cp out:lib/mysql-connector-j.jar br.com.pi.Main
```
- Windows cmd/PowerShell:
```bat
javac -cp lib\mysql-connector-j.jar -d out src\br\com\pi\Main.java src\br\com\pi\db\DbConfig.java src\br\com\pi\db\ConnectionFactory.java src\br\com\pi\model\Cliente.java src\br\com\pi\model\Produto.java src\br\com\pi\dao\ClienteDao.java src\br\com\pi\dao\ProdutoDao.java src\br\com\pi\ui\MainFrame.java src\br\com\pi\ui\ClientePanel.java src\br\com\pi\ui\ProdutoPanel.java
java -cp out;lib\mysql-connector-j.jar br.com.pi.Main
```

Pronto: ao clicar em "Cadastrar" nas abas, os registros são inseridos e o ID gerado é exibido.

