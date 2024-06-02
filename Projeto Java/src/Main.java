import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int GERENCIAR_CLIENTE = 1;
    private static final int GERENCIAR_FUNCIONARIO = 2;
    private static final int GERENCIAR_PRODUTO = 3;
    private static final int SAIR = 4;

    private static Scanner teclado = new Scanner(System.in);

    public static void mostrarErro(String mensagem)
    {
        System.out.println();
        System.out.println("++++++++++++++++++++++");
        System.out.println("ERRO:");
        System.out.println(mensagem);
        System.out.println("++++++++++++++++++++++");
        System.out.println();
    }

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
        try {
            return teclado.nextInt();
        }
        catch (InputMismatchException e)
        {
            mostrarErro("Digite um número!");
            teclado.nextLine();
            return 0;
        }

    }


    public static void main(String[] args) {

        System.out.println("Bem vindo ao sistema da papelaria Bacana!");

        int comando = 0;

        while (comando != SAIR)
        {
            mostrarComandos();
            comando = lerComando();

            switch (comando)
            {
                case GERENCIAR_CLIENTE:
                {
                    while (comando != GerenciadorClientes.SAIR)
                    {
                        System.out.println();
                        System.out.println("===========================================");
                        GerenciadorClientes.mostrarComandos();
                        comando = lerComando();
                        GerenciadorClientes.executarComando(comando, teclado);
                    }
                } break;

                case GERENCIAR_FUNCIONARIO:
                {
                    while (comando != GerenciadorFuncionarios.SAIR)
                    {
                        System.out.println();
                        System.out.println("===========================================");
                        GerenciadorFuncionarios.mostrarComandos();
                        comando = lerComando();
                        GerenciadorFuncionarios.executarComando(comando, teclado);
                    }
                } break;

                case GERENCIAR_PRODUTO:
                {
                    while (comando != GerenciadorProdutos.SAIR)
                    {
                        System.out.println();
                        System.out.println("===========================================");
                        GerenciadorProdutos.mostrarComandos();
                        comando = lerComando();
                        GerenciadorProdutos.executarComando(comando, teclado);
                    }
                } break;


                /*case GERENCIAR_FUNCIONARIO:
                    while (comando != SAIR)
                    {
                        comando = lerComando();
                        GerenciadorFuncionario.executarComando(comando);
                    }
                case GERENCIAR_PRODUTO:
                    while (comando != SAIR)
                    {
                        comando = lerComando();
                        GerenciadorProduto.executarComando(comando);
                   }*/
            }

        }
    }
}
