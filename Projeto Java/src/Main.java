import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int GERENCIAR_CLIENTE = 1;
    private static final int GERENCIAR_FUNCIONARIO = 2;
    private static final int GERENCIAR_PRODUTO = 3;
    private static final int SAIR = 4;

    private static Scanner teclado = new Scanner(System.in);

    public static void mostrarComandos()
    {
        System.out.println("Comandos disponíveis:");
        System.out.println("Gerenciar clientes ["+ GERENCIAR_CLIENTE +"]");
        System.out.println("Gerenciar funcionários ["+ GERENCIAR_FUNCIONARIO +"]");
        System.out.println("Gerenciar produtos ["+ GERENCIAR_PRODUTO +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }

    public static int lerComando()
    {
        return teclado.nextInt();
    }


    public static void main(String[] args) {

        System.out.println("Bem vindo ao sistema da papelaria Bacana!");

        GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();

        int comando = 0;

        while (comando != SAIR)
        {
            mostrarComandos();
            comando = lerComando();

            if (comando == GERENCIAR_CLIENTE)
            {
                try {
                    Cliente cliente = new Cliente("Arthur", 15, "Rua 23", "00000000", "(19)xxxxxxx");
                    gerenciadorClientes.adicionar(cliente);
                    gerenciadorClientes.mostrarTodos();
                    gerenciadorClientes.pesquisarPorNome("Art");
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

        }
    }
}
