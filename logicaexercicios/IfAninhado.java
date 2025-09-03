package logicaexercicios;

public class IfAninhado {
    public static void main(String[] args) {
        int nota = 8;
        int frequencia = 80;

        if (nota >= 7) {
            System.out.println("Nota maior que 7: " + nota);
            if (frequencia >= 75) {
                System.out.println("Aluno aprovado! Nota e frequencia excelentes");
            }
        }
    }
}
