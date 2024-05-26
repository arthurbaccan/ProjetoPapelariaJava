import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class GerenciadorFuncionarios {
    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    private static final int ADICIONAR_FUNCIONARIO = 1;
    private static final int REMOVER_FUNCIONARIO = 2;
    private static final int PESQUISAR_FUNCIONARIO = 3;
    private static final int MOSTRAR_TODOS = 4;
    public static final int SAIR = 5;

    public static void executarComando(int comando, Scanner teclado)
    {
        try{
            switch(comando) {
                case ADICIONAR_FUNCIONARIO: {
                    teclado.nextLine();
                    System.out.println("Digite o nome do Funcionário");
                    String nome = teclado.nextLine();
                    Pessoa.verificaNome(nome);
                    System.out.println("Digite a idade");
                    int idade = teclado.nextInt();
                    Pessoa.verificaIdade(idade);
                    System.out.println("Digite o endereço");
                    teclado.nextLine();
                    String endereco = teclado.nextLine();
                    System.out.println("Digite o código de resgitro");
                    String codigoDeRegistro = teclado.nextLine();

                    double salario=0;
                    for(int a=0; a==0;) {
                        System.out.println("Digite o salário");
                        String salarioString = teclado.nextLine();

                        try {
                            salario = Double.valueOf(salarioString);
                            a++;
                        }
                        catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("++++++++++++++++++++++");
                            System.out.println("ERRO:");
                            System.out.println("Salário deve ser um número!");
                            System.out.println("++++++++++++++++++++++");
                            System.out.println();
                        }
                    }
                    Funcionario fNovo = new Funcionario(nome, idade, endereco, codigoDeRegistro, salario);
                    GerenciadorFuncionarios.adicionar(fNovo);
                }break;

                case REMOVER_FUNCIONARIO:
                {
                    Funcionario fARemover = null;
                    teclado.nextLine();
                    System.out.println("Digite o código de resgitro");
                    String codigoDeRegistro = teclado.nextLine();
                    System.out.println("Removendo o Funcionário:");
                    for(Funcionario funcionario : listaFuncionarios) {
                        if (funcionario.codigoDeRegistro.equals(codigoDeRegistro)){
                            funcionario.exibir();
                            fARemover = funcionario;
                            break;
                        }
                    }
                    GerenciadorFuncionarios.remover(fARemover);
                }break;

                case PESQUISAR_FUNCIONARIO:
                {
                    teclado.nextLine();
                    System.out.println("Digite as letras iniciais do nome Funcionário");
                    String nome = teclado.nextLine();
                    GerenciadorFuncionarios.pesquisarPorNome(nome);
                } break;

                case MOSTRAR_TODOS:
                {
                    GerenciadorFuncionarios.mostrarTodos();
                }break;
            }
        } catch (IdadeInvalidaException e)
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
        catch (SalarioInvalidoException e)
        {
            System.out.println();
            System.out.println("++++++++++++++++++++++");
            System.out.println("ERRO:");
            System.out.println(e.getMessage());
            System.out.println("++++++++++++++++++++++");
            System.out.println();
        }
        catch (EnderecoVazioException e) {
            System.out.println();
            System.out.println("++++++++++++++++++++++");
            System.out.println("ERRO:");
            System.out.println(e.getMessage());
            System.out.println("++++++++++++++++++++++");
            System.out.println();
        }

    }

    public static void adicionar(Funcionario funcionario)
    {
        listaFuncionarios.add(funcionario);
    }

    public static void remover(Funcionario funcionario)
    {
        listaFuncionarios.remove(funcionario);
    }

    public static void pesquisarPorNome(String nomeFuncionario) {
        System.out.println("Resultados da pesquisa:");
        for(Funcionario funcionario : listaFuncionarios) {
            if (funcionario.nome.startsWith(nomeFuncionario))
                funcionario.exibir();
        }
    }

    public static void mostrarTodos() {
        for(Funcionario funcionario : listaFuncionarios) {
            funcionario.exibir();
        }
    }

    public static void mostrarComandos()
    {
        System.out.println("Comandos para gerenciar Funcionários:");
        System.out.println("Adicionar funcionário ["+ ADICIONAR_FUNCIONARIO +"]");
        System.out.println("Remover funcionário ["+ REMOVER_FUNCIONARIO +"]");
        System.out.println("Pesquisar funcionário por nome ["+ PESQUISAR_FUNCIONARIO +"]");
        System.out.println("Mostrar todos os funcionários ["+ MOSTRAR_TODOS +"]");
        System.out.println("Sair ["+ SAIR +"]");
    }
}
