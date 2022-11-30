import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
            setMenu = Integer.parseInt(reader.readLine());

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
        System.out.println(Utils.convertDoubleToString(sumOperationalFlow+sumFinancingFlow+sumInvestimentFlow+profitOrLoss));
    }

    private void showProfitOrLoss() {
        System.out.println("Total Lucro/Prejuízo: ");
        System.out.println(Utils.convertDoubleToString(profitOrLoss));
    }

    private void showInvestimentFlow() {
        System.out.println("Total Fluxo Investimento: ");
        investimentFlowList.forEach(item -> System.out.println(item.descricao + " : " + Utils.convertDoubleToString(item.valor)));
        System.out.println("Total: " + Utils.convertDoubleToString(sumInvestimentFlow));
    }

    private void showFinancingFlow() {
        System.out.println("Total Fluxo Financiamento: ");
        financingFlowList.forEach(item -> System.out.println(item.descricao + " : " + Utils.convertDoubleToString(item.valor)));
        System.out.println("Total :" + Utils.convertDoubleToString(sumFinancingFlow));
    }

    private void showOperationalFlow() {
        System.out.println("Total Fluxo Operacional: ");
        operationalFlowList.forEach(item -> System.out.println(item.descricao + " : " + item.valor));
        System.out.println("Total: " + Utils.convertDoubleToString(sumOperationalFlow));
    }

    private void addProfitOrLoss() throws IOException {
        System.out.println("Valor: ");
        profitOrLoss = Double.parseDouble(Utils.convertStringToDouble(reader.readLine()));
    }

    private void addInvestimentFlow() throws IOException {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        Utils.addParameter(parametrosDTO, reader);
        sumInvestimentFlow = sumInvestimentFlow + parametrosDTO.getValor();
        investimentFlowList.add(parametrosDTO);
    }

    private void addFinancingFlow() throws IOException {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        Utils.addParameter(parametrosDTO, reader);
        sumFinancingFlow = sumFinancingFlow + parametrosDTO.getValor();
        financingFlowList.add(parametrosDTO);
    }

    private void addOperationalFlow() throws IOException {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        Utils.addParameter(parametrosDTO, reader);
        sumOperationalFlow = sumOperationalFlow + parametrosDTO.getValor();
        operationalFlowList.add(parametrosDTO);
    }

}
