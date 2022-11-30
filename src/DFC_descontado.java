import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFC_descontado {
    ArrayList<Double> taxas = new ArrayList<>();
    ArrayList<Integer> anos = new ArrayList<>();
    ArrayList<Double> valorPrevistoAno = new ArrayList<>();
    ArrayList<Double> valorTotalAno = new ArrayList<>();
    Integer qtdAnos;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void valoresDFCDescontado() throws IOException {
        System.out.println("O DFC será de quantos anos? ");
        qtdAnos = Integer.valueOf(reader.readLine());
        for(int i = 0; i < qtdAnos; i++){
            System.out.println("Digite o ano: ");
            var ano = Integer.valueOf(reader.readLine());
            anos.add(ano);
            System.out.println("Digite o valor previsto para o ano "+ ano +": ");
            valorPrevistoAno.add(Double.valueOf(Utils.convertStringToDouble(reader.readLine())));
            System.out.println("Digite a taxa de juros(%) para o ano "+ ano +": ");
            taxas.add(Double.valueOf(Utils.convertStringToDouble(reader.readLine())));
        }
    }

    public void calcularDFCDescontado(){
        double total = 0.0;
        System.out.println("DFC Descontado por Ano: ");
        for(int i = 0; i< qtdAnos; i++) {
            valorTotalAno.add(valorPrevistoAno.get(i) - (valorPrevistoAno.get(i)*(taxas.get(i)/100)));
            System.out.println(anos.get(i) + " = " + Utils.convertDoubleToString(valorTotalAno.get(i)));
            total = total + valorTotalAno.get(i);
        }
        System.out.println("DFC Descontado Total: " + Utils.convertDoubleToString(total));
    }

    public void dfcDescontado() throws IOException {
        int escolha;
        do {
            System.out.println("Menu");
            System.out.println("1 - Adicionar Anos e Valores");
            System.out.println("2 - Calcular DFC Descontado");
            System.out.println("3 - Sair");
            escolha = Integer.parseInt(reader.readLine());

            switch (escolha) {
                case 1:
                    valoresDFCDescontado();
                    break;
                case 2:
                    calcularDFCDescontado();
                    break;
                case 3:
                    Menu menu = new Menu();
                    menu.menu();
                    break;
            }
        } while (escolha !=3);
    }
}
