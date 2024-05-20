import java.util.ArrayList;

public class GerenciadorClientes implements IGerenciador<Cliente>{
    private ArrayList<Cliente> listaClientes;

    private static final int ADICIONAR_CLIENTE = 1;
    private static final int REMOVER_CLIENTE = 2;
    private static final int PESQUISAR_CLIENTE = 3;
    private static final int MOSTRAR_TODOS = 4;
    private static final int SAIR = 5;

    public GerenciadorClientes() {
        this.listaClientes = new ArrayList<>();
    }

    @Override
    public void adicionar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    @Override
    public void mostrarTodos() {
        for(Cliente cliente : listaClientes) {

        }
    }

    public void pesquisarPorNome()
    {
        for(Cliente cliente : listaClientes) {

            cliente.exibir();
        }
    }


    @Override
    public void mostrarComandos() {
        System.out.println("Comandos para gerenciar Clientes:");
        System.out.println("Gerenciar clientes ["+ ADICIONAR_CLIENTE +"]");
        System.out.println("Gerenciar funcionários ["+ REMOVER_CLIENTE +"]");
        System.out.println("Gerenciar produtos ["+ PESQUISAR_CLIENTE +"]");
        System.out.println("Sair ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }


}

