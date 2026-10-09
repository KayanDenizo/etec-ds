package logicaexercicios;

import java.util.Scanner;

public class DoWhile {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Digite um numero (0 para sair): ");
            num = sc.nextInt();
        } while (num != 0);
        sc.close();
    }
}
