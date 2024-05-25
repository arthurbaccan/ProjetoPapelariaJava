import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorProdutos {
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static final int ADICIONAR_PRODUTO = 1;
    private static final int REMOVER_PRODUTO = 2;
    private static final int PESQUISAR_PRODUTO_NOME = 3;
    private static final int PESQUISAR_PRODUTO_DESCRICAO = 4;
    private static final int PESQUISAR_PRODUTO_PRECO = 5;
    private static final int MOSTRAR_TODOS = 6;
    public static final int SAIR = 7;

    public static boolean importadoConvert(String s)
    {
        boolean importadoBool;
        if(s.equals("s"))
        {
            importadoBool = true;
        } else if (s.equals("n")) {
            importadoBool = false;
        }
        else
        {
            throw new ValorParaImportadoInvalido();
        }
        return importadoBool;
    }

    public static void executarComando(int comando, Scanner teclado)
    {
        switch (comando){
            case ADICIONAR_PRODUTO:
            {
                teclado.nextLine();
                System.out.println("Digite o nome do produto");
                String nome = teclado.nextLine();
                Pessoa.verificaNome(nome);
                System.out.println("Digite a descrição");
                teclado.nextLine(); // Limpar o buffer, n sei pq precisa disso, mas sem não funciona
                String descricao = teclado.nextLine();
                System.out.println("Digite o preço");
                double preco = teclado.nextDouble();
                teclado.nextLine();
                System.out.println("É importado? [s/n]");
                String importado = teclado.nextLine();
                try {
                    boolean importadoBool = importadoConvert(importado);
                    Produto produtoNovo = new Produto(nome, descricao, preco, importadoBool);
                    GerenciadorProdutos.adicionar(produtoNovo);
                }
                catch (ValorParaImportadoInvalido e)
                {
                    System.out.println();
                    System.out.println("++++++++++++++++++++++");
                    System.out.println("ERRO:");
                    System.out.println(e.getMessage());
                    System.out.println("++++++++++++++++++++++");
                    System.out.println();
                }
            } break;

            case REMOVER_PRODUTO: {
                teclado.nextLine();
                System.out.println("Digite o código do produto a ser removido");
                int codigo = teclado.nextInt();
                Produto produtoARemover = null;
                for (Produto produto : listaProdutos) {
                    if (produto.codigoProduto == codigo) {
                        produto.exibir();
                        produtoARemover = produto;
                        break;
                    }
                }
                GerenciadorProdutos.remover(produtoARemover);
            }
        }
    }

    private static void adicionar(Produto produtoNovo)
    {
        listaProdutos.add(produtoNovo);
    }

    private static void remover(Produto produtoNovo)
    {
        listaProdutos.remove(produtoNovo);
    }

    public static void mostrarComandos() {
        System.out.println("Comandos para gerenciar Produtos:");
        System.out.println("Adicionar PRODUTO ["+ ADICIONAR_PRODUTO +"]");
        System.out.println("Remover produto ["+ REMOVER_PRODUTO +"]");
        System.out.println("Pesquisar produto por nome ["+ PESQUISAR_PRODUTO_NOME +"]");
        System.out.println("Pesquisar produto por descrição ["+ PESQUISAR_PRODUTO_DESCRICAO +"]");
        System.out.println("Pesquisar produto por preço ["+ PESQUISAR_PRODUTO_PRECO +"]");
        System.out.println("Mostrar todos os produtos ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }
}
