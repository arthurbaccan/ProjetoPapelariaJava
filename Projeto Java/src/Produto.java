public class Produto {
    protected int codigoProduto;
    protected String nome, descricao;
    protected double preco;
    protected boolean importado;
    protected static int maiorCodigo = 0;

    public Produto(String nome, String descricao, double preco, boolean importado) {
        checaNome(nome);
        this.nome = nome;
        checaDescricao(descricao);
        this.descricao = descricao;
        checaPreco(preco);
        this.preco = preco;
        this.importado = importado;
        Produto.maiorCodigo++;
        this.codigoProduto = Produto.maiorCodigo;
    }

    public static void checaDescricao(String descricao)
    {
        if (descricao.isEmpty())
        {
            throw new DescricaoVaziaException();
        }
    }

    public static void checaNome(String nome)
    {
        if (nome.isEmpty())
        {
            throw new NomeVazioException();
        }
    }

    public static void checaPreco(double preco)
    {
        if (preco < 0)
        {
            throw new PrecoInvalidoException();
        }
    }


    @Override
    public String toString() {
        return "Produto{" +
                "codigoProduto=" + codigoProduto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", importado=" + importado +
                '}';
    }

    public void exibir()
    {
        System.out.println(this);
    }

}
