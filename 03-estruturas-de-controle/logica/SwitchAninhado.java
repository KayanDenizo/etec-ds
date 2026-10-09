package logica;

public class SwitchAninhado {
    public static void main(String[] args) {
        int categoria = 1;
        int opcao = 2;

        switch (categoria) {
            case 1:
                System.out.println("Categoria: Matematica");
                switch (opcao) {
                    case 1:
                        System.out.println("Soma");
                        break;
                    case 2:
                        System.out.println("Subtração");
                        break;
                
                    default:
                        break;
                }
                break;
            case 2:
                System.out.println("Categoria: Texto");
                switch (opcao) {
                    case 1:
                        System.out.println("Contar letras");
                        break;
                    case 2:
                        System.out.println("Inverter string");
                        break;
                
                    default:
                        break;
                }
        
            default:
                break;
        }
    }
}
