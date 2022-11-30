import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFC_indireto {

    private static DFC_indireto instance;

    private DFC_indireto() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DFC_indireto getInstance() {
        if (instance == null) {
            instance = new DFC_indireto();
        }
        return instance;
    }

    double sumOperationalFlow = 0.00;
    double sumFinancingFlow = 0.00;
    double sumInvestimentFlow = 0.00;
    double profitOrLoss = 0.00;

    List<ParametrosDTO> operationalFlowList = new ArrayList<>();
    List<ParametrosDTO> financingFlowList = new ArrayList<>();
    List<ParametrosDTO> investimentFlowList = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);

    public void menuDFCIndireto() throws IOException {
        int setMenu;
        do {
            System.out.println("--------- Menu ------------");
            System.out.println("1 - Adicionar Item Fluxo Operacional");
            System.out.println("2 - Adicionar Item Fluxo Financiamento");
            System.out.println("3 - Adicionar Item Fluxo Investimento");
            System.out.println("4 - Adicionar Lucro/Prejuízo");
            System.out.println("5 - Calcular DFC Indireto");
            System.out.println("6 - Exibir Total Fluxo Operarional");
            System.out.println("7 - Exibir Total Fluxo Financiamento");
            System.out.println("8 - Exibir Total Fluxo Investimento");
            System.out.println("9 - Exibir Total Lucro/Prejuízo");
            System.out.println("0 - Sair");
            setMenu = scanner.nextInt();

            switch (setMenu) {
                case 1:
                    addOperationalFlow();
                    break;
                case 2:
                    addFinancingFlow();
                    break;
                case 3:
                    addInvestimentFlow();
                    break;
                case 4:
                    addProfitOrLoss();
                    break;
                case 5:
                    finalCashBalance();
                    break;
                case 6:
                    showOperationalFlow();
                    break;
                case 7:
                    showFinancingFlow();
                    break;
                case 8:
                    showInvestimentFlow();
                    break;
                case 9:
                    showProfitOrLoss();
                    break;
                case 0:
                    new Menu().menu();
                    break;

            }

        } while (setMenu != 0);
    }

    private void finalCashBalance() {
        System.out.println("DFC Indireto: ");
        System.out.println(sumOperationalFlow+sumFinancingFlow+sumInvestimentFlow+profitOrLoss);
    }

    private void showProfitOrLoss() {
        System.out.println("Total Lucro/Prejuízo: ");
        System.out.println(profitOrLoss);
    }

    private void showInvestimentFlow() {
        System.out.println("Total Fluxo Investimento: ");
        investimentFlowList.forEach(item -> System.out.println(item.descricao + " : " + item.valor));
        System.out.println("Total: " + sumInvestimentFlow);
    }

    private void showFinancingFlow() {
        System.out.println("Total Fluxo Financiamento: ");
        financingFlowList.forEach(item -> System.out.println(item.descricao + " : " + item.valor));
        System.out.println("Total :" + sumFinancingFlow);
    }

    private void showOperationalFlow() {
        System.out.println("Total Fluxo Operacional: ");
        operationalFlowList.forEach(item -> System.out.println(item.descricao + " : " + item.valor));
        System.out.println("Total: " + sumOperationalFlow);
    }

    private void addProfitOrLoss() {
        System.out.println("Valor: ");
        profitOrLoss = scanner.nextDouble();
    }

    private void addInvestimentFlow() {
        System.out.println("Descrição do Item: ");
        var description = scanner.next();
        System.out.println("Valor: ");
        var item = scanner.nextDouble();
        sumInvestimentFlow = sumInvestimentFlow + item;
        investimentFlowList.add(new ParametrosDTO(description, item));
    }

    private void addFinancingFlow() {
        System.out.println("Descrição do Item: ");
        var description = scanner.next();
        System.out.println("Valor: ");
        var item = scanner.nextDouble();
        sumFinancingFlow = sumFinancingFlow + item;
        financingFlowList.add(new ParametrosDTO(description, item));
    }

    private void addOperationalFlow() {
        System.out.println("Descrição do Item: ");
        var description = scanner.next();
        System.out.println("Valor: ");
        var item = scanner.nextDouble();
        sumOperationalFlow = sumOperationalFlow + item;
        operationalFlowList.add(new ParametrosDTO(description, item));
    }

}
