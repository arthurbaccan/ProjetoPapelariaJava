import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class GerenciadorClientes{
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

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

    public static String lerNome(Scanner teclado) {
        teclado.nextLine();
        System.out.println("Digite o nome do Funcionário");
        String nome = teclado.nextLine();
        Pessoa.verificaNome(nome);
        return nome;
    }

    public static int lerIdade(Scanner teclado) {
        System.out.println("Digite a idade");
        int idade = teclado.nextInt();
        Pessoa.verificaIdade(idade);
        return idade;
    }

    public static String lerEndereco(Scanner teclado) {
        teclado.nextLine();
        System.out.println("Digite o endereço");
        String endereco = teclado.nextLine();
        Funcionario.verificaEndereco(endereco);
        return endereco;
    }


    public static void executarComando(int comando, Scanner teclado)
    {

        try {

            switch (comando)
            {
                case ADICIONAR_CLIENTE:
                {
                    String nome = lerNome(teclado);
                    int idade = lerIdade(teclado);
                    String endereco = lerEndereco(teclado);
                    System.out.println("Digite o CPF");
                    String cpf = teclado.nextLine();
                    Cliente.checaCPF(cpf);
                    System.out.println("Digite o Telefone");
                    String telefone = teclado.nextLine();
                    Cliente.checaTelefone(telefone);

                    Cliente clNovo = new Cliente(nome, idade, endereco, cpf, telefone);
                    GerenciadorClientes.adicionar(clNovo);
                } break;

                case REMOVER_CLIENTE:
                {
                    
                    Cliente clARemover = null;
                    teclado.nextLine();
                    System.out.println("Digite o CPF");
                    String cpf = teclado.nextLine();
                    System.out.println("Removendo o Cliente:");
                    for(Cliente cliente : listaClientes) {
                        if (cliente.cpf.equals(cpf)){
                            cliente.exibir();
                            clARemover = cliente;
                            break;
                        }
                    }

                    GerenciadorClientes.remover(clARemover);

                } break;

                case MOSTRAR_CLIENTE_MAIS_VELHO:
                {
                    int maiorIdade = -1;
                    Cliente cliMaisVelho = null;
                    for(Cliente cliente : listaClientes) {
                        if (cliente.idade > maiorIdade)
                        {
                            cliMaisVelho = cliente;
                            maiorIdade = cliente.idade;
                        }

                    }

                    System.out.println("Cliente mais matioli(idoso): ");
                    try {
                        cliMaisVelho.exibir();
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("Nenhum cliente encontrado!");
                    }


                } break;

                case MOSTRAR_CLIENTE_MAIS_NOVO: {
                    int menorIdade = -1;
                    Cliente clienteMaisNovo = null;
                    for (Cliente cliente : listaClientes) {
                        if (menorIdade == -1)
                        {
                            menorIdade = cliente.idade;
                        }
                        else if (cliente.idade < menorIdade) {
                            clienteMaisNovo = cliente;
                            menorIdade = cliente.idade;
                        }

                    }

                    System.out.println("Cliente mais Arthur(criança): ");
                    try {
                        clienteMaisNovo.exibir();
                    } catch (NullPointerException e) {
                        System.out.println("Nenhum cliente encontrado!");
                    }

                }break;


                case MOSTRAR_MAIORES_60: {
                    int numerozin=0;
                    for(Cliente cliente: listaClientes)
                    {
                        if(cliente.idade > 60) {
                            numerozin++;
                        }
                    }
                    System.out.println("Clientes com mais de 60: "+numerozin);


                }break;

                case MOSTRAR_MENORES_18: {
                    int numerozin=0;
                    for(Cliente cliente: listaClientes)
                    {
                        if(cliente.idade < 18) {
                            numerozin++;
                        }
                    }
                    System.out.println("Clientes com menos de 18: "+numerozin);

                }break;

                case MOSTRAR_MEDIA_IDADE: {
                    int i = listaClientes.size() / 2;
                    double idade = 0;
                    for(Cliente cliente: listaClientes)
                    {
                        cliente.idade += idade;
                    }
                    System.out.println("Media: " + idade/i);
                }

                case PESQUISAR_CLIENTE:
                {
                    teclado.nextLine();
                    System.out.println("Digite as letras iniciais do nome Cliente");
                    String nome = teclado.nextLine();
                    GerenciadorClientes.pesquisarPorNome(nome);
                } break;


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
            Main.mostrarErro(e.getMessage());
        }
        catch (NomeVazioException e)
        {
            Main.mostrarErro(e.getMessage());
        }
        catch (InputMismatchException e)
        {
            Main.mostrarErro("Digite um número no campo!");
        }

        catch (CPFInvalidoException e)
        {
            Main.mostrarErro(e.getMessage());
        }

        catch (TelefoneInvalidoException e)
        {
            Main.mostrarErro(e.getMessage());
        }

        catch (EnderecoVazioException e)
        {
            Main.mostrarErro(e.getMessage());
        }

        catch (TelefoneVazioException e)
        {
            Main.mostrarErro(e.getMessage());
        }

        catch (CPFVazioException e)
        {
            Main.mostrarErro(e.getMessage());
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

