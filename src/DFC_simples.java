import java.util.ArrayList;
import java.util.Scanner;

public class DFC_simples {
    ArrayList<ParametrosDTO> entrada = new ArrayList<>();
    ArrayList<ParametrosDTO> saidas = new ArrayList<>();

    Double somaEntradas=0.0;
    Double somaSaidas=0.0;

    public void calculaDFCSimplesEntrada(String descricao, Double valor){
        ParametrosDTO par = new ParametrosDTO();
        par.descricao = descricao;
        par.valor = valor;

        entrada.add(par);

        somaEntradas = somaEntradas + valor;
    }

    public void mostrarEntradas(){
        System.out.println("Entradas: ");
        entrada.forEach(e -> System.out.println(e.descricao + " = " + e.valor));
    }

    public void mostrarTotalEntradas(){
        System.out.println("Total Entradas: "+ somaEntradas);
    }

    public void calculaDFCSimplesSaida(String descricao, Double valor){
        ParametrosDTO par = new ParametrosDTO();
        par.descricao = descricao;
        par.valor = valor;

        saidas.add(par);

        somaSaidas = somaSaidas + valor;
    }

    public void mostrarSaidas(){
        System.out.println("Saidas: ");

        saidas.forEach(e -> System.out.println(e.descricao + " = " + e.valor));
    }

    public void mostrarTotalSaidas(){
        System.out.println("Total Saidas: "+ somaSaidas);
    }

    public void calcularDfc(){
        System.out.println("DFC Simples: ");
        System.out.println(somaEntradas-somaSaidas);
    }
    public void calcularDfcSimples(){
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        do {
            System.out.println("Menu");
            System.out.println("1 - Adicionar Entrada");
            System.out.println("2 - Adicionar Saida");
            System.out.println("3 - Mostrar Entradas");
            System.out.println("4 - Mostrar Saidas");
            System.out.println("5 - Calcular DFC Simples");
            System.out.println("6 - Sair");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("1 - Adicionar Entrada");
                    System.out.println("Descrição da Entrada: ");
                    var descricao = scanner.next();
                    System.out.println("Valor: ");
                    var valor = scanner.nextDouble();
                    calculaDFCSimplesEntrada(descricao, valor);
                    break;
                case 2:
                    System.out.println("2 - Adicionar Saida");
                    System.out.println("Descrição da Saida: ");
                    descricao = scanner.next();
                    System.out.println("Valor: ");
                    valor = scanner.nextDouble();
                    calculaDFCSimplesSaida(descricao, valor);
                    break;
                case 3:
                    mostrarEntradas();
                    mostrarTotalEntradas();
                    break;
                case 4:
                    mostrarSaidas();
                    mostrarTotalSaidas();
                    break;
                case 5:
                    calcularDfc();
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menu();
                    break;
            }
        }while (escolha !=6);

    }
}
