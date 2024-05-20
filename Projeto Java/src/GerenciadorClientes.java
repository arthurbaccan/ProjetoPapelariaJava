import java.util.ArrayList;

public abstract class GerenciadorClientes {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    private static final int ADICIONAR_CLIENTE = 1;
    private static final int REMOVER_CLIENTE = 2;
    private static final int PESQUISAR_CLIENTE = 3;
    private static final int MOSTRAR_TODOS = 4;
    private static final int SAIR = 5;




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

    public void mostrarComandos() {
        System.out.println("Comandos para gerenciar Clientes:");
        System.out.println("Remover cliente ["+ ADICIONAR_CLIENTE +"]");
        System.out.println("Gerenciar funcionários ["+ REMOVER_CLIENTE +"]");
        System.out.println("Gerenciar produtos ["+ PESQUISAR_CLIENTE +"]");
        System.out.println("Sair ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }


}

