public class Funcionario extends Pessoa implements IPessoa{

    private String endereco;
    private int codigoDeRegistro;
    private double salario;

    public Funcionario(String nome, int idade, String endereco, int codigoDeRegistro, double salario) {
        super(nome, idade);
        this.endereco = endereco;
        this.codigoDeRegistro = codigoDeRegistro;
        this.salario = salario;
    }

    @Override
    public void exibir() {
        System.out.println("\nFuncionário: "+nome+"\nIdade: "+idade+"\nEndereco: "+endereco+"\nCodigo de Registro: "+codigoDeRegistro+"\nSalario: "+salario);
    }
}
