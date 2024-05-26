public class TelefoneVazioException extends RuntimeException{
    @Override
    public String getMessage() {
        return "O telefone não pode ser vazio!";
    }
}
