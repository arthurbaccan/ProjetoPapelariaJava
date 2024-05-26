public class DescricaoVaziaException extends RuntimeException{
    @Override
    public String getMessage() {
        return "A descrição não pode ser vazia!";
    }
}
