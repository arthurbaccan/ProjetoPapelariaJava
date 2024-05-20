public  abstract class Pessoa implements IPessoa {
    private String nome;
    private int idade;

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

    public void setNome(String nome) {
        if (nome.isEmpty())
        {
            throw new NomeVazioException();
        }

        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 1 || idade > 120)
        {
            throw new IdadeInvalidaException();
        }

        this.idade = idade;
    }
}
