public class Funcionario extends Pessoa implements IPessoa{

    private String edereco;
    private int codigoDeRegistro;
    private double salario;

    public Funcionario(String nome, int idade, String edereco, int codigoDeRegistro, double salario) {
        super(nome, idade);
        this.edereco = edereco;
        this.codigoDeRegistro = codigoDeRegistro;
        this.salario = salario;
    }

    @Override
    public void exibir() {

    }
}
