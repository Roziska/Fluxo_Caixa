import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public enum DFCDiretoEnum {

    OPERATIONAL_FLOW(1, "Adicionar Fluxo Operacional") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) throws IOException {
            int item;
            do {
                System.out.println(textFlow);
                item = Integer.parseInt(scanner.readLine());
                int finalItem = item;
                Arrays.stream(OperationalFlowEnum.values())
                        .filter(of -> of.getValue() == finalItem)
                        .findFirst()
                        .ifPresent(of -> {
                            ParametrosDTO parametrosDTO = new ParametrosDTO();
                            addOperationalFlowDetail(scanner, textParameter, operationalFlow, of, parametrosDTO);
                            parametrosDTO.setType(OPERATIONAL_FLOW);
                            parameterList.add(parametrosDTO);
                        });
            } while (item != 8);
        }
    },
    FINANCING_FLOW(2, "Adicionar Fluxo Investimento") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) throws IOException {
            ParametrosDTO parametrosDTO = new ParametrosDTO();
            Utils.addParameters(parametrosDTO, scanner, textParameter);
            parametrosDTO.setType(FINANCING_FLOW);
            parameterList.add(parametrosDTO);
        }
    },
    INVESTIMENT_FLOW(3, "Adicionar Fluxo Financiamento") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) throws IOException {
            ParametrosDTO parametrosDTO = new ParametrosDTO();
            Utils.addParameters(parametrosDTO, scanner, textParameter);
            parametrosDTO.setType(INVESTIMENT_FLOW);
            parameterList.add(parametrosDTO);
        }
    },
    SHOW_OPERATIONAL_FLOW(4, "Mostrar Fluxo Operational") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) {
            showOperationalFlow(operationalFlow);
        }
    },
    SHOW_FINANCING_FLOW(5, "Mostar Fluxo Financiamento") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) {
            double financing = DFCDiretoEnum.calculateFlow(parameterList, FINANCING_FLOW).get();
            showFinancingFlow(financing);

        }
    },
    SHOW_INVESTIMENT_FLOW(6, "Mostrar Fluxo Investimento") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) {
            double investiment = DFCDiretoEnum.calculateFlow(parameterList, INVESTIMENT_FLOW).get();
            showInvestimentFlow(investiment);
        }
    },
    CALCULATE_DIRECT_DFC(7, "Calcular DFC direto") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) {
            double operational = Utils.calculateOperationalFlow(operationalFlow);
            double financing = DFCDiretoEnum.calculateFlow(parameterList, FINANCING_FLOW).get();
            double investiment = DFCDiretoEnum.calculateFlow(parameterList, INVESTIMENT_FLOW).get();
            double total = operational + financing + investiment;
            DFCDiretoEnum.showOperationalFlow(operationalFlow);
            DFCDiretoEnum.showFinancingFlow(financing);
            DFCDiretoEnum.showInvestimentFlow(investiment);
            System.out.println("DFC: " + total + "\n");
        }
    },
    EXIT(8, "Sair") {
        @Override
        public void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) throws IOException {
            Menu menu = new Menu();
            menu.menu();
        }
    };

    private static void showOperationalFlow(OperationalFlow operationalFlow) {
        System.out.println("FLUXO OPERACIONAL: " + Utils.convertDoubleToString(Utils.calculateOperationalFlow(operationalFlow)));
        System.out.println("(+) Recebimento de Clientes: " + Utils.convertDoubleToString(operationalFlow.getCustomerReceipt()));
        System.out.println("(-) Pagamento de Forncedores: " + Utils.convertDoubleToString(operationalFlow.getSupplierPayment()));
        System.out.println("(-) Despesas Administrativas: " + Utils.convertDoubleToString(operationalFlow.getAdministrativeExpense()));
        System.out.println("(-) Despesas de Venda: " + Utils.convertDoubleToString(operationalFlow.getSellingExpense()));
        System.out.println("(-) Despesas de Pessoal: " + Utils.convertDoubleToString(operationalFlow.getEmployeeExpense()));
        System.out.println("(-) Despesas de Financiamento: " + Utils.convertDoubleToString(operationalFlow.getFinancingExpense()));
        if (operationalFlow.getOtherExpense() > 0.0)
            System.out.println(("(-) Outras Despesas: " + Utils.convertDoubleToString(operationalFlow.getOtherExpense())));
        System.out.println("\n");
    }

    private static void addOperationalFlowDetail(BufferedReader scanner, String textParameter, OperationalFlow operationalFlow, OperationalFlowEnum of, ParametrosDTO parametrosDTO) {
        try {
            of.addOperationalFlowDetail(parametrosDTO, operationalFlow, scanner, textParameter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showFinancingFlow(double financing) {
        System.out.println("FLUXO FINANCIMANTO: " + Utils.convertDoubleToString(financing) + "\n");
    }

    private static AtomicReference<Double> calculateFlow(List<ParametrosDTO> parameterList, DFCDiretoEnum flow) {
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        parameterList.stream()
                .filter(p -> p.getType().equals(flow))
                .forEach(p -> total.set(total.get() + p.getValor()));
        return total;
    }

    private static void showInvestimentFlow(double investiment) {
        System.out.println("FLUXO INVESTIMENTO: " + Utils.convertDoubleToString(investiment) + "\n");
    }

    public static final Map<DFCDiretoEnum, String> DFC_DIRETO_ENUM_MAP = new EnumMap<>(DFCDiretoEnum.class);

    static {
        Arrays.stream(values()).forEach(dfc -> DFC_DIRETO_ENUM_MAP.put(dfc, dfc.getDescription()));
    }

    private final int value;
    private final String description;

    DFCDiretoEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public abstract void action(BufferedReader scanner, String textFlow, String textParameter, OperationalFlow operationalFlow, List<ParametrosDTO> parameterList) throws IOException;

}
