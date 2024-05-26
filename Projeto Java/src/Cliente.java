public class Cliente extends Pessoa{
    private String endereco;
    protected String cpf;
    private String telefone;

    public Cliente(String nome, int idade, String endereco, String cpf, String telefone) {
        super(nome, idade);
        checaEndereco(endereco);
        this.endereco = endereco;
        checaCPF(cpf);
        this.cpf = cpf;
        checaTelefone(telefone);
        this.telefone = telefone;
    }

    public static void checaEndereco(String endereco)
    {
        if (endereco.isEmpty())
        {
            throw new EnderecoVazioException();
        }
    }

    public static void checaCPF(String cpf)
    {
        if (cpf.isEmpty())
        {
            throw new CPFVazioException();
        } else if (cpf.length() != 11) {
            throw new CPFInvalidoException();
        }
    }
    public static void checaTelefone(String telefone)
    {
        if (telefone.isEmpty())
        {
            throw new TelefoneVazioException();
        } else if (telefone.length() < 8) {
            throw new TelefoneInvalidoException();
        }
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
