public class Pessoa {
    private String nome;

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ana");
        System.out.println("nome: " + pessoa.getNome());
    }



}
