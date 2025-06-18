public class GatoAbstracao extends AnimalAbstracao {

    public GatoAbstracao(String nome) {
        super(nome);
    }


    @Override
    public void emitirSom(){
        System.out.println("miai");
    }
}
