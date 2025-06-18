public class CachorroAbstracao extends AnimalAbstracao{
    public CachorroAbstracao (String nome) {
        super(nome);
    }

    @Override
    public void emitirSom(){
        System.out.println("Au, au");
    }
}
