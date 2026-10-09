public class CirculoInterfaces implements FormaInterfaces {
    private double raio;

    public CirculoInterfaces(double raio){
        this.raio = raio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * raio * raio;
    }

}