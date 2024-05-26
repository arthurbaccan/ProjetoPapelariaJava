public class TelefoneInvalidoException extends RuntimeException{
    @Override
    public String getMessage() {
        return "O telefone deve ter no mínimo 8 dígitos";
    }
}
