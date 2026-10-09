import java.text.Normalizer;

public class TestaFormaInterfaces {
    public static void main(String [] args) {
        FormaInterfaces circulo = new CirculoInterfaces(raio: 2);
        FormaInterfaces retangulo = new RetanguloInterfaces(largura: 3, altura: 4);

        System.out.println("Área do circulo: "+ circulo.calcularArea());
        System.out.println("Área do retangulo: "+ retangulo.calcularArea());
    }
}
