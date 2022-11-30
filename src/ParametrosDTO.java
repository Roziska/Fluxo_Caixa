public class ParametrosDTO {
    String descricao;
    Double valor;
    OperationalFlowEnum operationalFlowType;
    DFCDiretoEnum type;

    public ParametrosDTO() {}

    public ParametrosDTO(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OperationalFlowEnum getOperationalFlowType() {
        return operationalFlowType;
    }

    public void setOperationalFlowType(OperationalFlowEnum operationalFlowType) {
        this.operationalFlowType = operationalFlowType;
    }

    public DFCDiretoEnum getType() {
        return type;
    }

    public void setType(DFCDiretoEnum type) {
        this.type = type;
    }
}
