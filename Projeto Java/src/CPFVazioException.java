public class CPFVazioException extends RuntimeException{
    @Override
    public String getMessage() {
        return "CPF não pode ser vazio!";
    }
}
