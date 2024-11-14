package pagamento;

import usuario.Cliente;
import usuario.User;

public interface Pagamento {
    boolean autorizarPagamento(String senha, User user);
    void processarPagamento(boolean autorizado, Cliente user);
    void confimrarPagamento();
    String gerarCodigo();
}