package pagamento;

import java.security.SecureRandom;
import java.util.Scanner;
import usuario.Cliente;
import usuario.User;

public class Pix extends PagamentoBase {
    private transient Scanner scan = new Scanner(System.in);

    public Pix(double valor) {
        super(valor);
    }

    @Override
    public String gerarCodigo() {
        String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int TAMANHO_CHAVE_PIX = 32;
        SecureRandom random = new SecureRandom();
        
        StringBuilder chavePix = new StringBuilder(TAMANHO_CHAVE_PIX);
        
        for (int i = 0; i < TAMANHO_CHAVE_PIX; i++) {
            int index = random.nextInt(ALFABETO.length());
            chavePix.append(ALFABETO.charAt(index));
        }
        
        return chavePix.toString();
    }

    @Override
    public boolean autorizarPagamento(String Senha, User user) {
        String codigo = gerarCodigo();
        System.out.println("Código do pix: " + codigo); 

        System.out.println("Codigo do Pix:");
        String codigoUsuario = scan.nextLine();

        System.out.println("Senha:");
        String senhaUsuario = scan.nextLine();

        if (user.getSenha().equals(senhaUsuario) && codigo.contentEquals(codigoUsuario)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void processarPagamento(boolean autorizado, Cliente user) {
        if (!autorizado) {
            System.out.println("Senha ou código incorreto!");
        } else {
            user.EsvaziarCarrinho();
            this.confimrarPagamento();
        }
    }
}

