package logicaexercicios;

import java.util.Scanner;

public class SwitchAninhado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;
        int subOpcao;

        do {
            // Menu principal
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Usuários");
            System.out.println("2. Gerenciar Produtos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    // Submenu de usuários
                    System.out.println("\n--- GERENCIAR USUÁRIOS ---");
                    System.out.println("1. Cadastrar Usuário");
                    System.out.println("2. Listar Usuários");
                    System.out.println("3. Voltar");
                    System.out.print("Escolha uma subopção: ");
                    subOpcao = scanner.nextInt();

                    switch (subOpcao) {
                        case 1:
                            System.out.println("Usuário cadastrado com sucesso!");
                            break;
                        case 2:
                            System.out.println("Listando usuários...");
                            break;
                        case 3:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Subopção inválida.");
                            break;
                    }
                    break;

                case 2:
                    // Submenu de produtos
                    System.out.println("\n--- GERENCIAR PRODUTOS ---");
                    System.out.println("1. Adicionar Produto");
                    System.out.println("2. Listar Produtos");
                    System.out.println("3. Voltar");
                    System.out.print("Escolha uma subopção: ");
                    subOpcao = scanner.nextInt();

                    switch (subOpcao) {
                        case 1:
                            System.out.println("Produto adicionado com sucesso!");
                            break;
                        case 2:
                            System.out.println("Listando produtos...");
                            break;
                        case 3:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Subopção inválida.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Linha em branco para separar as execuções
        } while (opcaoPrincipal != 3);

        scanner.close();
    }
}
