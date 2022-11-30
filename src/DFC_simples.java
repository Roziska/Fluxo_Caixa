import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFC_simples {
    ArrayList<ParametrosDTO> entrada = new ArrayList<>();
    ArrayList<ParametrosDTO> saidas = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Double somaEntradas=0.0;
    Double somaSaidas=0.0;

    public void calculaDFCSimplesEntrada() throws IOException {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        Utils.addParameter(parametrosDTO, reader);
        entrada.add(parametrosDTO);
        somaEntradas = somaEntradas + parametrosDTO.getValor();
    }

    public void mostrarEntradas(){
        System.out.println("Entradas: ");
        entrada.forEach(e -> System.out.println(e.descricao + " = " + Utils.convertDoubleToString(e.valor)));
    }

    public void mostrarTotalEntradas(){
        System.out.println("Total Entradas: "+ Utils.convertDoubleToString(somaEntradas));
    }

    public void calculaDFCSimplesSaida() throws IOException {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        Utils.addParameter(parametrosDTO, reader);
        saidas.add(parametrosDTO);
        somaSaidas = somaSaidas + parametrosDTO.getValor();
    }

    public void mostrarSaidas(){
        System.out.println("Saidas: ");

        saidas.forEach(e -> System.out.println(e.descricao + " = " + Utils.convertDoubleToString(e.valor)));
    }

    public void mostrarTotalSaidas(){
        System.out.println("Total Saidas: "+ Utils.convertDoubleToString(somaSaidas));
    }

    public void calcularDfc(){
        System.out.println("DFC Simples: ");
        System.out.println(Utils.convertDoubleToString(somaEntradas-somaSaidas));
    }
    public void calcularDfcSimples() throws IOException {

        int escolha;
        do {
            System.out.println("Menu");
            System.out.println("1 - Adicionar Entrada");
            System.out.println("2 - Adicionar Saida");
            System.out.println("3 - Mostrar Entradas");
            System.out.println("4 - Mostrar Saidas");
            System.out.println("5 - Calcular DFC Simples");
            System.out.println("6 - Sair");
            escolha = Integer.parseInt(reader.readLine());

            switch (escolha) {
                case 1:
                    calculaDFCSimplesEntrada();
                    break;
                case 2:
                    calculaDFCSimplesSaida();
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
