import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum ParametersEnum {

    ADD_DESCRIPTION(1, "Adicionar Descrição") {
        @Override
        public void addParameter(ParametrosDTO parameter, BufferedReader reader) throws IOException {
            System.out.print("Descrição: ");
            var linha = reader.readLine();
            parameter.setDescricao(linha);
        }
    },
    ADD_VALUE(2, "Adicionar Valor") {
        @Override
        public void addParameter(ParametrosDTO parameter, BufferedReader reader) throws IOException {
            System.out.print("Valor: ");
            var value = Utils.convertStringToDouble(reader.readLine());
            parameter.setValor(Double.valueOf(value));
        }
    },
    EXIT(3, "Sair") {
        @Override
        public void addParameter(ParametrosDTO parameter, BufferedReader reader) throws IOException {
            DFC_direto.getInstance().menuDFCDireto();
        }
    };

    public static final Map<ParametersEnum, String> PARAMETERS_ENUM_MAP = new EnumMap<>(ParametersEnum.class);

    static {
        Arrays.stream(values())
                .forEach(p -> PARAMETERS_ENUM_MAP.put(p, p.getDescription()));
    }

    private final int value;
    private final String description;

    ParametersEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public abstract void addParameter(ParametrosDTO parameter, BufferedReader reader) throws IOException;
}
