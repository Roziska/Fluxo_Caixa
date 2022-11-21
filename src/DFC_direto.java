import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFC_direto {

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

    List<ParametrosDTO> receipts = new ArrayList<>();
    List<ParametrosDTO> payments = new ArrayList<>();
    double sumReceipts = 0.0;
    double sumPayments = 0.0;
    double openingCashBalance = 0.0;
    Scanner scanner = new Scanner(System.in);

    public void menuDFCDireto() {
        int setMenu;
        do {
            System.out.println("--------- Menu ------------");
            System.out.println("1 - Adicionar Saldo Inicial de Caixa");
            System.out.println("2 - Adicionar Recebimentos");
            System.out.println("3 - Adicionar Pagamentos");
            System.out.println("4 - Saldo Operacional de Caixa");
            System.out.println("5 - Calcular DFC Direto");
            System.out.println("6 - Exibir Recebimentos");
            System.out.println("7 - Exibir Pagamentos");
            System.out.println("8 - Exibir Saldo de Caixa");
            System.out.println("9 - Sair");
            setMenu = scanner.nextInt();

            switch (setMenu) {
                case 1:
                    addOpeningCashBalance();
                    break;
                case 2:
                    addReceipts();
                    break;
                case 3:
                    addPayments();
                    break;
                case 4:
                    cashOperatingBalance();
                    break;
                case 5:
                    finalCashBalance();
                    break;
                case 6:
                    showReceipts();
                    break;
                case 7:
                    showPayments();
                    break;
                case 8:
                    showOpeningCashBalance();
                    break;
                case 9:
                    new Menu().menu();
                    break;

            }

        } while (setMenu != 9);
    }

    private void showOpeningCashBalance() {
        System.out.println("Saldo Inicial de Caixa: ");
        System.out.println(openingCashBalance);
    }

    private void showPayments() {
        System.out.println("Pagamentos: ");
        payments.forEach(payment -> System.out.println(payment.descricao + " : " + payment.valor));
    }

    private void showReceipts() {
        System.out.println("Recebimentos: ");
        receipts.forEach(receipt -> System.out.println(receipt.descricao + " : " + receipt.valor));
    }

    private void finalCashBalance() {
        System.out.println("DFC Direto: ");
        System.out.println(openingCashBalance+sumReceipts-sumPayments);

    }

    private void cashOperatingBalance() {
        System.out.println("Saldo Operacional de Caixa: ");
        System.out.println(sumReceipts-sumPayments);
    }

    private void addPayments() {
        System.out.println("Descrição do Pagamento: ");
        var description = scanner.next();
        System.out.println("Valor: ");
        var payment = scanner.nextDouble();
        sumPayments = sumPayments + payment;
        payments.add(new ParametrosDTO(description, payment));
    }

    private void addReceipts() {
        System.out.println("Descrição do Recebimento: ");
        var description = scanner.next();
        System.out.println("Valor: ");
        var receipt = scanner.nextDouble();
        sumReceipts = sumReceipts + receipt;
        receipts.add(new ParametrosDTO(description, receipt));
    }

    private void addOpeningCashBalance() {
        System.out.println("Valor do Saldo Inicial de Caixa: ");
        openingCashBalance = scanner.nextDouble();
    }


}
