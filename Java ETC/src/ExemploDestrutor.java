public class ExemploDestrutor {
    protected void finalize() {
        System.out.println("Objeto esta sendo removido pela Garbage Collector");

    }

    public static void main(String[] args) {
        ExemploDestrutor exemplo = new ExemploDestrutor();
        exemplo = null;
        System.gc();
    }
}
