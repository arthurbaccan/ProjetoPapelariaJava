public class Produto {
    private int codigoProduto;
    private String nome, descricao;
    private double preco;
    private boolean importado;

    public Produto(int codigoProduto, String nome, String descricao, double preco, boolean importado) {
        this.codigoProduto = codigoProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.importado = importado;
    }


}
