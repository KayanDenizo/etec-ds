package logicaexercicios;

public class ComContinue {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                continue;  // Pula o resto do loop para múltiplos de 3
            }
            System.out.println(i);
        }
    }
}
