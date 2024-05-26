public class Funcionario extends Pessoa implements IPessoa{

    private String endereco;
    protected String codigoDeRegistro;
    private double salario;

    public Funcionario(String nome, int idade, String endereco, String codigoDeRegistro, double salario) {
        super(nome, idade);
        this.endereco = endereco;
        this.codigoDeRegistro = codigoDeRegistro;
        setSalario(salario);
    }

    @Override
    public void exibir() {
        System.out.println("\nFuncionário: "+nome+"\nIdade: "+idade+"\nEndereco: "+endereco+"\nCódigo de Registro: "+codigoDeRegistro+"\nSalário: "+salario);
    }

    public double getSalario() {
        return salario;
    }

    public static void verificaSalario(double salario) {
        if (salario<=0)
        {
            throw new SalarioInvalidoException();
        }
    }

    public void setSalario(double salario) {
        verificaSalario(salario);

        this.salario = salario;
    }

}
