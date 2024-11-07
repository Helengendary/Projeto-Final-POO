class VerifyExcepiton extends Exception {
    public VerifyExcepiton(String mensagem) {
        super("\n"+mensagem);
    }
}

public class Exceptions {

    public static void verificarValor(String valor, String links) throws VerifyExcepiton {
        if (!valor.chars().anyMatch(c -> c >= '0' && c <= '9')) {
            throw new VerifyExcepiton("NAO EH UM NUMERO!");
        } else {
            String atual = "";
            Boolean igual = false;
            for (int i = 0; i < links.length(); i++) {
                if (links.charAt(i) == '|' || i == links.length()-1) {
                    if (atual.equals(valor.trim())) {
                        igual = true;
                        break;
                    }
                    atual = "";
                    continue;
                }
                atual += links.charAt(i);
            }
            if (!igual) {
                throw new VerifyExcepiton("DIGITE UM NUMERO VALIDO!");
            }
        }
    }

    public static void possivelCPF() throws VerifyExcepiton {
        
    }
}
