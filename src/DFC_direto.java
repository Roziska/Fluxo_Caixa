import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFC_direto {

    public static final String SUB_MENU = "-------- SubMenu ---------";
    public static final String LINE_BREAK = "\n";
    public static final String SEPARATOR = " - ";
    private static DFC_direto instance;
    private DFC_direto() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static DFC_direto getInstance() {
        if (instance == null) {
            instance = new DFC_direto();
        }
        return instance;
    }
    OperationalFlow operationalFlow = new OperationalFlow();
    List<ParametrosDTO> parameterList = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void menuDFCDireto() throws IOException {
        int setMenu;
        do {
            System.out.println(createInitText());
            setMenu = Integer.parseInt(reader.readLine());

            int finalSetMenu = setMenu;
            Arrays.stream(DFCDiretoEnum.values())
                    .filter(direto -> direto.getValue() == finalSetMenu)
                    .findFirst()
                    .ifPresent(this::action);

        } while (setMenu != 9);
    }

    private void action(DFCDiretoEnum dfc) {
        try {
            dfc.action(reader, createOperationalFlowText(),
                    createParameterText(), operationalFlow, parameterList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createInitText() {
        return "--------- Menu ------------" +
                LINE_BREAK +
                DFCDiretoEnum.OPERATIONAL_FLOW.getValue() +
                SEPARATOR +
                DFCDiretoEnum.OPERATIONAL_FLOW.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.FINANCING_FLOW.getValue() +
                SEPARATOR +
                DFCDiretoEnum.FINANCING_FLOW.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.INVESTIMENT_FLOW.getValue() +
                SEPARATOR +
                DFCDiretoEnum.INVESTIMENT_FLOW.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.SHOW_OPERATIONAL_FLOW.getValue() +
                SEPARATOR +
                DFCDiretoEnum.SHOW_OPERATIONAL_FLOW.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.SHOW_FINANCING_FLOW.getValue() +
                SEPARATOR +
                DFCDiretoEnum.SHOW_FINANCING_FLOW.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.SHOW_INVESTIMENT_FLOW.getValue() +
                SEPARATOR +
                DFCDiretoEnum.SHOW_INVESTIMENT_FLOW.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.CALCULATE_DIRECT_DFC.getValue() +
                SEPARATOR +
                DFCDiretoEnum.CALCULATE_DIRECT_DFC.getDescription() +
                LINE_BREAK +
                DFCDiretoEnum.EXIT.getValue() +
                SEPARATOR +
                DFCDiretoEnum.EXIT.getDescription() +
                LINE_BREAK;
    }

    private String createParameterText() {
        return SUB_MENU +
                LINE_BREAK +
                ParametersEnum.ADD_DESCRIPTION.getValue() +
                SEPARATOR +
                ParametersEnum.ADD_DESCRIPTION.getDescription() +
                LINE_BREAK +
                ParametersEnum.ADD_VALUE.getValue() +
                SEPARATOR +
                ParametersEnum.ADD_VALUE.getDescription() +
                LINE_BREAK +
                ParametersEnum.EXIT.getValue() +
                SEPARATOR +
                ParametersEnum.EXIT.getDescription() +
                LINE_BREAK;
    }

    private String createOperationalFlowText() {
        return SUB_MENU +
                LINE_BREAK +
                OperationalFlowEnum.CUSTOMER_RECEIPT.getValue() +
                SEPARATOR +
                OperationalFlowEnum.CUSTOMER_RECEIPT.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.SUPPLIER_PAYMENT.getValue() +
                SEPARATOR +
                OperationalFlowEnum.SUPPLIER_PAYMENT.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.ADMINISTRATIVE_EXPENSE.getValue() +
                SEPARATOR +
                OperationalFlowEnum.ADMINISTRATIVE_EXPENSE.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.SELLING_EXPENSE.getValue() +
                SEPARATOR +
                OperationalFlowEnum.SELLING_EXPENSE.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.EMPLOYEE_EXPENSE.getValue() +
                SEPARATOR +
                OperationalFlowEnum.EMPLOYEE_EXPENSE.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.FINANCING_EXPENSE.getValue() +
                SEPARATOR +
                OperationalFlowEnum.FINANCING_EXPENSE.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.OTHER_EXPENSE.getValue() +
                SEPARATOR +
                OperationalFlowEnum.OTHER_EXPENSE.getDescription() +
                LINE_BREAK +
                OperationalFlowEnum.EXIT.getValue() +
                SEPARATOR +
                OperationalFlowEnum.EXIT.getDescription() +
                LINE_BREAK;
    }


}
