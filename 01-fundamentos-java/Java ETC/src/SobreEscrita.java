class Animal {
    public void emitirSom() {
        System.out.println("Animal faz som");
    }
}

class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au Au");
    }
}

public class SobreEscrita {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cachorro = new Cachorro();

        animal.emitirSom();
        cachorro.emitirSom();

    }
}