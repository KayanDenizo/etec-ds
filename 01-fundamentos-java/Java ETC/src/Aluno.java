public class Aluno {
    String nome;

    // Metodo construtor
    public Aluno(String nome) {
        this.nome = nome;
    }

    // Void = Nao retorna valor
    public void exibirAluno() {
        System.out.println("Aluno: " + nome);
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Pedro");
        aluno.exibirAluno();
    }
}
