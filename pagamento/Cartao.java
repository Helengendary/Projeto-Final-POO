package pagamento;

import java.util.Scanner;
import usuario.Cliente;
import usuario.User;

public class Cartao extends PagamentoBase {
    private String numeroCartao;
    private String validade;
    private String cvv;

    public Cartao(Double valor, String numcad, String vali, String cvv) {
        super(valor);
        this.numeroCartao = numcad;
        this.validade = vali;
        this.cvv = cvv;
    }

    private transient Scanner scan = new Scanner(System.in);


    @Override
    public void processarPagamento(boolean autorizado, Cliente user) {
        if (!autorizado) {
            System.out.println("Senha incorreta!");
        } else {
            user.EsvaziarCarrinho();
            this.confimrarPagamento();
        }
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public void gerarCodigo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean autorizarPagamento(String Senha, User user) {
        System.out.println("Senha:");
        String senhaUsuario = scan.nextLine();

        if (user.getSenha().equals(senhaUsuario)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean autorizarPagamento(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
