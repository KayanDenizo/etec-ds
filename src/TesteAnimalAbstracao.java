public class TesteAnimalAbstracao {
    public static void main(String[] args) {
        AnimalAbstracao cachorro = new CachorroAbstracao("Billy");
        AnimalAbstracao gato = new GatoAbstracao("Bibi");

        cachorro.emitirSom();
        gato.emitirSom();
    }
}
