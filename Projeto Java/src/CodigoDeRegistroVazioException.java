public class CodigoDeRegistroVazioException extends RuntimeException{
    @Override
    public String getMessage() {
        return "O código de registro não pode ser vazio!";
    }
}
