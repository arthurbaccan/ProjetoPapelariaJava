public class NomeVazioException extends RuntimeException{

    @Override
    public String getMessage() {
        return "O nome não pode ser vazio!";
    }
}
