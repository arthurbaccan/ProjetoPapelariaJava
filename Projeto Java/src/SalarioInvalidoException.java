public class SalarioInvalidoException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Salário inválido!";
    }
}
