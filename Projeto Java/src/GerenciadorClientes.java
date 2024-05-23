import java.util.ArrayList;
import java.util.Scanner;

public abstract class GerenciadorClientes {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static String input;

    private static final int ADICIONAR_CLIENTE = 1;
    private static final int REMOVER_CLIENTE = 2;
    private static final int PESQUISAR_CLIENTE = 3;
    private static final int MOSTRAR_TODOS = 4;
    private static final int SAIR = 5;


    public static void executarComando(int comando, Scanner teclado)
    {

        try {

            switch (comando)
            {
                case ADICIONAR_CLIENTE:
                {
                    System.out.println("Digite o nome do Cliente");
                    String nome = teclado.nextLine();
                    System.out.println("Digite a idade");
                    int idade = teclado.nextInt();
                    System.out.println("Digite o endereço");
                    String endereco = teclado.nextLine();
                    System.out.println("Digite o CPF");
                    String cpf = teclado.nextLine();
                    System.out.println("Digite o Telefone");
                    String telefone = teclado.nextLine();

                    Cliente clNovo = new Cliente(nome, idade, endereco, cpf, telefone);
                    GerenciadorClientes.adicionar(clNovo);
                }

                case MOSTRAR_TODOS:
                {
                    GerenciadorClientes.mostrarTodos();
                }
            }
            /*
            adicionar(cliente);
            GerenciadorClientes.mostrarTodos();
            GerenciadorClientes.pesquisarPorNome("Art");*/
        }
        catch (IdadeInvalidaException e)
        {
            System.out.println(e.getMessage());
        }
        catch (NomeVazioException e)
        {
            System.out.println(e.getMessage());
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

    public static void pesquisarPorNome(String nome)
    {
        System.out.println("Resultados da pesquisa:");
        for(Cliente cliente : listaClientes) {
            if (cliente.nome.startsWith(nome))
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
        System.out.println("Gerenciar funcionários ["+ REMOVER_CLIENTE +"]");
        System.out.println("Gerenciar produtos ["+ PESQUISAR_CLIENTE +"]");
        System.out.println("Sair ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }


}

