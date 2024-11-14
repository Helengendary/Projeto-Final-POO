package pagamento;

import usuario.Cliente;
import usuario.User;

public interface Pagamento {
    boolean autorizarPagamento(User user);
    void processarPagamento(boolean autorizado, Cliente user);
    void confimrarPagamento();
    void gerarCodigo();
}