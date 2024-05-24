public class Produto {
    private int codigoProduto;
    private String nome, descricao;
    private double preco;
    private boolean importado;
    private static int maiorCodigo = 0;

    public Produto(String nome, String descricao, double preco, boolean importado) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.importado = importado;
        Produto.maiorCodigo++;
        this.codigoProduto = Produto.maiorCodigo;
    }


}
