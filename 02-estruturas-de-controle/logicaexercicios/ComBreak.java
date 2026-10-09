package logicaexercicios;

public class ComBreak {
    public static void main(String[] args) {
        int[] numeros = {3, 5, 2, 7, 9, 4};

        for (int num : numeros) {
            if (num == 7) {
                System.out.println("Número 7 encontrado! Parando o loop.");
                break;
            }
            System.out.println("Número atual: " + num);
        }
    }
}
