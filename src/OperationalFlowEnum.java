import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum OperationalFlowEnum {

    CUSTOMER_RECEIPT(1, "Adicionar Recebimento de Cliente") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(CUSTOMER_RECEIPT);
            operationalFlow.setCustomerReceipt(parametrosDTO.getValor());
        }
    },
    SUPPLIER_PAYMENT(2, "Adicionar Pagamento de Forncedores") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(SUPPLIER_PAYMENT);
            operationalFlow.setSupplierPayment(parametrosDTO.getValor());
        }
    },
    ADMINISTRATIVE_EXPENSE(3, "Adicionar Despesas Administrativas") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(ADMINISTRATIVE_EXPENSE);
            operationalFlow.setAdministrativeExpense(parametrosDTO.getValor());
        }
    },
    SELLING_EXPENSE(4, "Adicionar Despesas de Vendas") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(SELLING_EXPENSE);
            operationalFlow.setSellingExpense(parametrosDTO.getValor());
        }
    },
    EMPLOYEE_EXPENSE(5, "Adicionar Despesas de Pessoal") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(EMPLOYEE_EXPENSE);
            operationalFlow.setEmployeeExpense(parametrosDTO.getValor());
        }
    },
    FINANCING_EXPENSE(6, "Adicionar Despesas de Financiamento") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(FINANCING_EXPENSE);
            operationalFlow.setFinancingExpense(parametrosDTO.getValor());
        }
    },
    OTHER_EXPENSE(7, "Adicionar Outras Despesas") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            Utils.addParameters(parametrosDTO, scanner, parameterText);
            parametrosDTO.setOperationalFlowType(OTHER_EXPENSE);
            operationalFlow.setOtherExpense(parametrosDTO.getValor());
        }
    },
    EXIT (8, "Sair") {
        @Override
        public void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException {
            DFC_direto.getInstance().menuDFCDireto();
        }
    };

    public static final Map<OperationalFlowEnum, String> OPERATIONAL_FLOW_ENUM_MAP = new EnumMap<>(OperationalFlowEnum.class);

    static {
        Arrays.stream(values()).forEach(of -> OPERATIONAL_FLOW_ENUM_MAP.put(of, of.getDescription()));
    }

    public abstract void addOperationalFlowDetail(ParametrosDTO parametrosDTO, OperationalFlow operationalFlow, BufferedReader scanner, String parameterText) throws IOException;

    private final int value;
    private final String description;

    OperationalFlowEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }


}
