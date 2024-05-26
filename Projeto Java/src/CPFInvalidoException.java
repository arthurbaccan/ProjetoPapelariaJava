public class CPFInvalidoException extends RuntimeException{
    @Override
    public String getMessage() {
        return "O CPF deve ter 11 dígitos!";
    }
}
