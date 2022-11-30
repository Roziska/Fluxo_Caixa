public class OperationalFlow {

    private double customerReceipt;
    private double supplierPayment;
    private double administrativeExpense;
    private double sellingExpense;
    private double employeeExpense;
    private double financingExpense;
    private double otherExpense;

    private double totalOperationFlow;

    public OperationalFlow() {
        this.customerReceipt = 0.0;
        this.supplierPayment = 0.0;
        this.administrativeExpense = 0.0;
        this.sellingExpense = 0.0;
        this.employeeExpense = 0.0;
        this.financingExpense = 0.0;
        this.otherExpense = 0.0;
        this.totalOperationFlow = 0.0;
    }

    public double getCustomerReceipt() {
        return customerReceipt;
    }

    public void setCustomerReceipt(double customerReceipt) {
        this.customerReceipt = this.customerReceipt + customerReceipt;
    }

    public double getSupplierPayment() {
        return supplierPayment;
    }

    public void setSupplierPayment(double supplierPayment) {
        this.supplierPayment = this.supplierPayment + supplierPayment;
    }

    public double getAdministrativeExpense() {
        return administrativeExpense;
    }

    public void setAdministrativeExpense(double administrativeExpense) {
        this.administrativeExpense = this.administrativeExpense + administrativeExpense;
    }

    public double getSellingExpense() {
        return sellingExpense;
    }

    public void setSellingExpense(double sellingExpense) {
        this.sellingExpense = this.sellingExpense + sellingExpense;
    }

    public double getEmployeeExpense() {
        return employeeExpense;
    }

    public void setEmployeeExpense(double employeeExpense) {
        this.employeeExpense = this.employeeExpense + employeeExpense;
    }

    public double getFinancingExpense() {
        return financingExpense;
    }

    public void setFinancingExpense(double financingExpense) {
        this.financingExpense = this.financingExpense + financingExpense;
    }

    public double getOtherExpense() {
        return otherExpense;
    }

    public void setOtherExpense(double otherExpense) {
        this.otherExpense = this.otherExpense + otherExpense;
    }

    public double getTotalOperationFlow() {
        return totalOperationFlow = totalOperationFlow + customerReceipt - supplierPayment - administrativeExpense - sellingExpense - employeeExpense - financingExpense - otherExpense;
    }
}
