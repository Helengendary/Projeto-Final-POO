package pagamento;

import java.security.SecureRandom;
import java.util.Scanner;
import usuario.Cliente;
import usuario.User;

public class Boleto extends PagamentoBase {
    private transient Scanner scan = new Scanner(System.in);

    public Boleto(double valor) {
        super(valor);
    }

    @Override
    public String gerarCodigo() {
        String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int TAMANHO_CODIGO_PIX = 6;
        SecureRandom random = new SecureRandom();
        
        StringBuilder codigoPix = new StringBuilder(TAMANHO_CODIGO_PIX);
        
        for (int i = 0; i < TAMANHO_CODIGO_PIX; i++) {
            int index = random.nextInt(ALFABETO.length());
            codigoPix.append(ALFABETO.charAt(index));
        }
        
        return codigoPix.toString();
    }

    @Override
    public boolean autorizarPagamento(String Senha, User user) {
        String codigo = gerarCodigo();
        System.out.println("Código do Boleto: " + codigo); 

        System.out.println("Codigo do Boleto:");
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

