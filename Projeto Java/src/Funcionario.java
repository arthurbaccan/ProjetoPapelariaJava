public class Funcionario extends Pessoa implements IPessoa{

    private String endereco;
    protected String codigoDeRegistro;
    private String salario;

    public Funcionario(String nome, int idade, String endereco, String codigoDeRegistro, String salario) {
        super(nome, idade);
        this.endereco = endereco;
        this.codigoDeRegistro = codigoDeRegistro;
        this.salario = salario;
    }

    @Override
    public void exibir() {
        System.out.println("\nFuncionário: "+nome+"\nIdade: "+idade+"\nEndereco: "+endereco+"\nCódigo de Registro: "+codigoDeRegistro+"\nSalário: "+salario);
    }
}
