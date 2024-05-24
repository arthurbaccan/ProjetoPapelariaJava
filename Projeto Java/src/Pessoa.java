public  abstract class Pessoa implements IPessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public static void verificaNome(String nome)
    {
        if (nome.isEmpty())
        {
            throw new NomeVazioException();
        }
    }

    public static void verificaIdade(int idade)
    {
        if (idade < 0)
        {
            throw new IdadeInvalidaException();
        }
    }

    public void setNome(String nome) {
        verificaNome(nome);

        this.nome = nome;
    }

    public void setIdade(int idade) {
        verificaIdade(idade);

        this.idade = idade;
    }
}
