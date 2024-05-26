public class EnderecoVazioException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Endereço vazio!";
    }
}
