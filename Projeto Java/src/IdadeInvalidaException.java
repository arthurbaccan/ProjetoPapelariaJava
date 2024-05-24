public class IdadeInvalidaException extends RuntimeException {
    @Override
    public String getMessage() {
        return "A idade deve ser maior que 0";
    }
}
