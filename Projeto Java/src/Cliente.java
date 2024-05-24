public class Cliente extends Pessoa{
    private String endereco;
    protected String cpf;
    private String telefone;

    public Cliente(String nome, int idade, String endereco, String cpf, String telefone) {
        super(nome, idade);
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "endereco='" + endereco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", idade=" + super.getIdade() +
                '}';
    }

    @Override
    public void exibir() {
        System.out.println(this);
    }
}
