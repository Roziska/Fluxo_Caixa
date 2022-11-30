import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Utils {

    public static void addParameters(ParametrosDTO parameter, BufferedReader reader, String text) throws IOException {
        int select;
        do {
            if (parameter.getDescricao() != null && parameter.getValor() != null) break;
            System.out.print(text);
            select = Integer.parseInt(reader.readLine());
            int finalSelect = select;
            Arrays.stream(ParametersEnum.values())
                    .filter(p -> p.getValue() == finalSelect)
                    .findFirst()
                    .ifPresent(e -> addParameter(parameter, reader, e));
        } while (select != 3);
    }

    private static void addParameter(ParametrosDTO parameter, BufferedReader reader, ParametersEnum parameters) {
        try {
            parameters.addParameter(parameter, reader);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}