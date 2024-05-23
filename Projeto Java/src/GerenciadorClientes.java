import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class GerenciadorClientes {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static String input;

    private static final int ADICIONAR_CLIENTE = 1;
    private static final int REMOVER_CLIENTE = 2;
    private static final int PESQUISAR_CLIENTE = 3;
    private static final int MOSTRAR_CLIENTE_MAIS_VELHO = 4;
    private static final int MOSTRAR_CLIENTE_MAIS_NOVO = 5;
    private static final int MOSTRAR_MAIORES_60 = 6;
    private static final int MOSTRAR_MENORES_18 = 7;
    private static final int MOSTRAR_MEDIA_IDADE = 8;
    private static final int MOSTRAR_TODOS = 9;
    public static final int SAIR = 10;


    public static void executarComando(int comando, Scanner teclado)
    {

        try {

            switch (comando)
            {
                case ADICIONAR_CLIENTE:
                {
                    teclado.nextLine();
                    System.out.println("Digite o nome do Cliente");
                    String nome = teclado.nextLine();
                    System.out.println("Digite a idade");
                    int idade = teclado.nextInt();
                    System.out.println("Digite o endereço");
                    teclado.nextLine(); // Limpar o buffer, n sei pq precisa disso, mas sem não funciona
                    String endereco = teclado.nextLine();
                    System.out.println("Digite o CPF");
                    String cpf = teclado.nextLine();
                    System.out.println("Digite o Telefone");
                    String telefone = teclado.nextLine();

                    Cliente clNovo = new Cliente(nome, idade, endereco, cpf, telefone);
                    GerenciadorClientes.adicionar(clNovo);
                } break;

                case PESQUISAR_CLIENTE:
                {
                    teclado.nextLine();
                    System.out.println("Digite as letras iniciais do nome Cliente");
                    String nome = teclado.nextLine();
                    GerenciadorClientes.pesquisarPorNome(nome);
                }

                case MOSTRAR_TODOS:
                {
                    GerenciadorClientes.mostrarTodos();
                } break;
            }
            /*
            adicionar(cliente);
            GerenciadorClientes.mostrarTodos();
            GerenciadorClientes.pesquisarPorNome("Art");*/
        }
        catch (IdadeInvalidaException e)
        {
            System.out.println();
            System.out.println("++++++++++++++++++++++");
            System.out.println("ERRO:");
            System.out.println(e.getMessage());
            System.out.println("++++++++++++++++++++++");
            System.out.println();
        }
        catch (NomeVazioException e)
        {
            System.out.println();
            System.out.println("++++++++++++++++++++++");
            System.out.println("ERRO:");
            System.out.println(e.getMessage());
            System.out.println("++++++++++++++++++++++");
            System.out.println();
        }
        catch (InputMismatchException e)
        {
            System.out.println();
            System.out.println("++++++++++++++++++++++");
            System.out.println("ERRO:");
            System.out.println("Digite um número no campo!");
            System.out.println("++++++++++++++++++++++");
            System.out.println();
        }
    }


    public static void adicionar(Cliente cliente) {
        listaClientes.add(cliente);
    }


    public static void remover(Cliente cliente) {
        listaClientes.remove(cliente);
    }


    public static void mostrarTodos() {
        for(Cliente cliente : listaClientes) {
            cliente.exibir();
        }
    }

    public static void pesquisarPorNome(String nomeCli)
    {
        System.out.println("Resultados da pesquisa:");
        for(Cliente cliente : listaClientes) {
            if (cliente.nome.startsWith(nomeCli))
                cliente.exibir();
        }
    }

    public static void getClienteMaisVelho()
    {
        Cliente clienteEscolhido = null;
        for(Cliente cliente : listaClientes) {
            if (clienteEscolhido == null)
            {

            }
        }
    }

    public static void mostrarComandos() {
        System.out.println("Comandos para gerenciar Clientes:");
        System.out.println("Adicionar cliente ["+ ADICIONAR_CLIENTE +"]");
        System.out.println("Remover cliente ["+ REMOVER_CLIENTE +"]");
        System.out.println("Pesquisar cliente por nome ["+ PESQUISAR_CLIENTE +"]");
        System.out.println("Mostrar o cliente mais velho ["+ MOSTRAR_CLIENTE_MAIS_VELHO +"]");
        System.out.println("Mostrar o cliente mais novo ["+ MOSTRAR_CLIENTE_MAIS_NOVO +"]");
        System.out.println("Mostrar a quantidade de clientes maiores de 60 ["+ MOSTRAR_MAIORES_60 +"]");
        System.out.println("Mostrar a quantidade de clientes menores de 18 ["+ MOSTRAR_MENORES_18 +"]");
        System.out.println("Mostrar a média de idade dos clientes ["+ MOSTRAR_MEDIA_IDADE +"]");
        System.out.println("Mostrar todos os clientes ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }


}

