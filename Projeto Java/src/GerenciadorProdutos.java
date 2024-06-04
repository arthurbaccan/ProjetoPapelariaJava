import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorProdutos {
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static final int ADICIONAR_PRODUTO = 1;
    private static final int REMOVER_PRODUTO = 2;
    private static final int PESQUISAR_PRODUTO_NOME = 3;
    private static final int PESQUISAR_PRODUTO_DESCRICAO = 4;
    private static final int PESQUISAR_PRODUTO_PRECO = 5;
    private static final int PESQUISAR_PRODUTO_MAIS_CARO = 6;
    private static final int PESQUISAR_PRODUTO_MAIS_BARATO = 7;
    private static final int MOSTRAR_MEDIA_PRECO = 8;
    private static final int PESQUISAR_PRODUTO_ACIMA_MEDIA = 9;
    private static final int MOSTRAR_TODOS = 10;
    public static final int SAIR = 11;

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
        try {


            switch (comando) {
                case ADICIONAR_PRODUTO: {
                    teclado.nextLine();
                    System.out.println("Digite o nome do produto");
                    String nome = teclado.nextLine();
                    Produto.checaNome(nome);
                    System.out.println("Digite a descrição");
                    //teclado.nextLine(); // Limpar o buffer, n sei pq precisa disso, mas sem não funciona
                    String descricao = teclado.nextLine();
                    Produto.checaDescricao(descricao);
                    System.out.println("Digite o preço");
                    double preco = teclado.nextDouble();
                    Produto.checaPreco(preco);
                    teclado.nextLine();
                    System.out.println("É importado? [s/n]");
                    String importado = teclado.nextLine();

                    try {
                        boolean importadoBool = importadoConvert(importado);
                        Produto produtoNovo = new Produto(nome, descricao, preco, importadoBool);
                        GerenciadorProdutos.adicionar(produtoNovo);
                    } catch (ValorParaImportadoInvalido e) {
                        System.out.println();
                        System.out.println("++++++++++++++++++++++");
                        System.out.println("ERRO:");
                        System.out.println(e.getMessage());
                        System.out.println("++++++++++++++++++++++");
                        System.out.println();
                    }
                }
                break;

                case REMOVER_PRODUTO: {
                    teclado.nextLine();
                    System.out.println("Digite o código do produto a ser removido");
                    int codigo = teclado.nextInt();
                    Produto produtoARemover = null;
                    System.out.println("Removendo o produto:");
                    for (Produto produto : listaProdutos) {
                        if (produto.codigoProduto == codigo) {
                            produto.exibir();
                            produtoARemover = produto;
                            break;
                        }
                    }
                    GerenciadorProdutos.remover(produtoARemover);
                }
                break;

                case MOSTRAR_TODOS: {
                    GerenciadorProdutos.mostrarTodos();
                }
                break;

                case PESQUISAR_PRODUTO_NOME: {
                    teclado.nextLine();
                    System.out.println("Digite as letras iniciais do nome do produto");
                    String nome = teclado.nextLine();
                    GerenciadorProdutos.pesquisarPorNome(nome);
                }
                break;

                case PESQUISAR_PRODUTO_DESCRICAO: {
                    teclado.nextLine();
                    System.out.println("Digite o começo da descricão do produto");
                    String descricao = teclado.nextLine();
                    GerenciadorProdutos.pesquisarPorDescricao(descricao);
                }
                break;

                case PESQUISAR_PRODUTO_PRECO: {

                    System.out.println("Digite o preço do produto");
                    double preco = teclado.nextDouble();
                    GerenciadorProdutos.pesquisarPorPreco(preco);
                }
                break;

                case PESQUISAR_PRODUTO_MAIS_CARO: {
                    System.out.println("Produto mais caro:");
                    mostrarMaisCaro();
                }
                break;

                case PESQUISAR_PRODUTO_MAIS_BARATO: {
                    System.out.println("Produto mais barato:");
                    mostrarMaisBarato();
                }
                break;

                case MOSTRAR_MEDIA_PRECO: {
                    mostrarMediaPreco();
                }
                break;

                case PESQUISAR_PRODUTO_ACIMA_MEDIA:
                {
                    mostrarQtdAcimaMedia();
                }
                break;

            }
        }
        catch (NomeVazioException e)
        {
            Main.mostrarErro(e.getMessage());
        }

        catch (PrecoInvalidoException e)
        {
            Main.mostrarErro(e.getMessage());
        }

        catch (DescricaoVaziaException e)
        {
            Main.mostrarErro(e.getMessage());
        }
        catch (InputMismatchException e)
        {
            Main.mostrarErro("Digite um número no campo!");
        }
    }


    public static void pesquisarPorDescricao(String descricaoProduto)
    {
        System.out.println("Resultados da pesquisa:");
        for(Produto produto : listaProdutos) {
            if (produto.descricao.startsWith(descricaoProduto))
                produto.exibir();
        }
    }

    public static Produto getProdMaisCaro()
    {
        double produtoMaisCaro = listaProdutos.getFirst().preco;
        Produto prodObjectMaisCaro = listaProdutos.getFirst();
        for (Produto produto : listaProdutos) {
            if (produto.preco > produtoMaisCaro) {
                produtoMaisCaro = produto.preco;
                prodObjectMaisCaro = produto;
            }
        }
        return prodObjectMaisCaro;
    }

    public static Produto getProdMaisCaro(ArrayList<Produto> listaProdutos)
    {
        double produtoMaisCaro = listaProdutos.getFirst().preco;
        Produto prodObjectMaisCaro = listaProdutos.getFirst();
        for (Produto produto : listaProdutos) {
            if (produto.preco > produtoMaisCaro) {
                produtoMaisCaro = produto.preco;
                prodObjectMaisCaro = produto;
            }
        }
        return prodObjectMaisCaro;
    }

    public static void mostrarMaisCaro()
    {
        Produto prodObjectMaisCaro = getProdMaisCaro();
        try {
            prodObjectMaisCaro.exibir();
        } catch (NullPointerException e)
        {
            System.out.println("Nenhum produto encontrado!");
        }
    }

    public static void mostrarQtdAcimaMedia() {
        double mediaPreco = calcularMediaPreco();
        int qtdAcimaMedia = 0;
        for (Produto produto : listaProdutos) {
            if (produto.preco > mediaPreco)
            {
                qtdAcimaMedia++;
            }
        }
        System.out.println("Quantidade de produtos acima da média de preço: " + qtdAcimaMedia);
    }

    public static Produto getProdutoMaisBarato()
    {
        double produtoMaisBarato = listaProdutos.getFirst().preco;
        Produto prodObjectMaisBarato = listaProdutos.getFirst();
        for (Produto produto : listaProdutos) {
            if (produto.preco < produtoMaisBarato) {
                produtoMaisBarato = produto.preco;
                prodObjectMaisBarato = produto;
            }
        }

        return prodObjectMaisBarato;
    }

    public static Produto getProdutoMaisBarato(ArrayList<Produto> listaProdutos)
    {
        double produtoMaisBarato = listaProdutos.getFirst().preco;
        Produto prodObjectMaisBarato = listaProdutos.getFirst();
        for (Produto produto : listaProdutos) {
            if (produto.preco < produtoMaisBarato) {
                produtoMaisBarato = produto.preco;
                prodObjectMaisBarato = produto;
            }
        }

        return prodObjectMaisBarato;
    }

    public static void mostrarMaisBarato()
    {
        Produto prodObjectMaisBarato = getProdutoMaisBarato();

        try {
            prodObjectMaisBarato.exibir();
        } catch (NullPointerException e)
        {
            System.out.println("Nenhum produto encontrado!");
        }
    }

    public static double calcularMediaPreco(ArrayList<Produto> listaProdutos)
    {
        double mediaPreco = 0;
        for (Produto produto : listaProdutos) {
            mediaPreco += produto.preco;
        }
        return mediaPreco / (listaProdutos.size());
    }

    public static double calcularMediaPreco()
    {
        double mediaPreco = 0;
        for (Produto produto : listaProdutos) {
            mediaPreco += produto.preco;
        }
        return mediaPreco / (listaProdutos.size());
    }


    public static void mostrarMediaPreco() {
        double mediaPreco = calcularMediaPreco();
        System.out.println("Média de preço: " + mediaPreco);
    }


    public static void pesquisarPorPreco(double preco)
    {
        System.out.println("Resultados da pesquisa:");
        for(Produto produto : listaProdutos) {
            if (produto.preco >= preco-0.001 && produto.preco <= preco+0.001) // margem de erro pra casas decimais.
                produto.exibir();
        }
    }

    public static void pesquisarPorNome(String nomeProduto)
    {
        System.out.println("Resultados da pesquisa:");
        for(Produto produto : listaProdutos) {
            if (produto.nome.startsWith(nomeProduto))
                produto.exibir();
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

    private static void mostrarTodos()
    {
        for (Produto produto : listaProdutos)
        {
            produto.exibir();
        }
    }


    public static void mostrarComandos() {
        System.out.println("Comandos para gerenciar Produtos:");
        System.out.println("Adicionar produto ["+ ADICIONAR_PRODUTO +"]");
        System.out.println("Remover produto ["+ REMOVER_PRODUTO +"]");
        System.out.println("Pesquisar produto por nome ["+ PESQUISAR_PRODUTO_NOME +"]");
        System.out.println("Pesquisar produto por descrição ["+ PESQUISAR_PRODUTO_DESCRICAO +"]");
        System.out.println("Pesquisar produto por preço ["+ PESQUISAR_PRODUTO_PRECO +"]");
        System.out.println("Mostrar produto mais caro ["+ PESQUISAR_PRODUTO_MAIS_CARO+"]");
        System.out.println("Mostrar produto mais barato ["+ PESQUISAR_PRODUTO_MAIS_BARATO+"]");
        System.out.println("Mostrar preco médio ["+ MOSTRAR_MEDIA_PRECO +"]");
        System.out.println("Mostrar quantidade de produtos acima da média de preço ["+ PESQUISAR_PRODUTO_ACIMA_MEDIA+"]");
        System.out.println("Mostrar todos os produtos ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }
}
