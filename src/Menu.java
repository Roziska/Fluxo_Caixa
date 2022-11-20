import java.util.Scanner;

public class Menu {
    public void menu(){
        DFC_simples dfcSimples = new DFC_simples();
        DFC_descontado dfcDescontado = new DFC_descontado();

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- Menu Principal ------------");
        System.out.println("1 - DFC Simples");
        System.out.println("2 - DFC Descontado");

        var escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                dfcSimples.calcularDfcSimples();
                break;
            case 2:
                dfcDescontado.dfcDescontado();
                break;
            default:
                return;
        }
    }
}