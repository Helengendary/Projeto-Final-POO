package pagamento;

import usuario.User;

public abstract class PagamentoBase implements Pagamento {
    private double valor;
    private String Status;

    public PagamentoBase(double valor) {
        this.valor = valor;
        this.Status = "pendente";
    }

    @Override
    public void confimrarPagamento() {
        this.Status = "confirmado";
        System.out.println("\nPagamento confirmado\n");
    }

    public abstract boolean autorizarPagamento(String Senha, User user);

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
