package exception;

public class VerifyExcepiton extends Exception {
    public VerifyExcepiton(String mensagem) {
        super("\n"+mensagem);
    }
}
