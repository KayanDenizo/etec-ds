package logicaexercicios;

public class ForAninhado {
    public static void main(String[] args) {
        int linhas = 5;
        int colunas = 5;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print((i + j) + "\t");
            }
            System.out.println();
        }
    }

}
