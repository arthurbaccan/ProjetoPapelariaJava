public class IdadeInvalidaException extends RuntimeException {
    @Override
    public String getMessage() {
        return "A idade deve estar entre 1 e 150";
    }
}
