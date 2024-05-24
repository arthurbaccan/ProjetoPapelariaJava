public class ValorParaImportadoInvalido extends RuntimeException{
    @Override
    public String getMessage() {
        return "O valor deve ser s ou n, porém outro valor foi inserido";
    }
}
