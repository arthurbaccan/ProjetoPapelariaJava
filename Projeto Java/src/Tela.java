import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Tela extends JFrame implements ActionListener{

    //campos do cliente
    PlaceholderTextField pesquisarCli;
    JButton adicionarCli;
    JButton removerCli;
    JButton maisNovo;
    JButton maisVelho;
    JButton acima60;
    JButton abaixo18;
    JButton mediaIdade;

    //lista clientes
    JPanel menuCli;
    JTable listaCli;
    JScrollPane scrollListaCli;
    private static ArrayList<Cliente> arrayListaCli = new ArrayList<>();

    //campos do menu cliente
    JTextField addNomeCli;
    JTextField addIdadeCli;
    JTextField addEnderecoCli;
    JTextField addCpfCli;
    JTextField addTelefoneCli;

    JLabel nomeCli;
    JLabel idadeCli;
    JLabel enderecoCli;
    JLabel cpfCli;
    JLabel telefoneCli;

    JButton salvarCli;
    JButton cancelarCli;

    //metodos cliente
    DefaultTableModel modeloCli;

    //campos do funcionario
    PlaceholderTextField pesquisarFun;
    JButton adicionarFun;
    JButton removerFun;

    //lista funcionario
    JPanel menuFun;
    JTable listaFun;
    JScrollPane scrollListaFun;
    private static ArrayList<Funcionario> arrayListaFun = new ArrayList<>();

    //campos do menu funcionario
    JTextField addNomeFun;
    JTextField addIdadeFun;
    JTextField addEnderecoFun;
    JTextField addCodigoFun;
    JTextField addSalario;

    JLabel nomeFun;
    JLabel idadeFun;
    JLabel enderecoFun;
    JLabel codigoFun;
    JLabel salarioFun;

    JButton salvarFun;
    JButton cancelarFun;

    //metodos funcionario
    DefaultTableModel modeloFun;

    //campos do produto
    PlaceholderTextField pesquisarNomePro;
    PlaceholderTextField pesquisarDescriPro;
    PlaceholderTextField pesquisarPrecoPro;
    JButton adicionarPro;
    JButton removerPro;
    JButton maisCaroPro;
    JButton maisBaratoPro;
    JButton mediaPrecoPro;
    JButton qtdAcimaMedia;

    //lista produto
    JPanel menuPro;
    JTable listaPro;
    JScrollPane scrollListaPro;
    private static ArrayList<Produto> arrayListaPro = new ArrayList<>();

    //campos do menu produto
    JTextField addNomePro;
    JTextField addDescriPro;
    JTextField addPrecoPro;
    JTextField addImportPro;

    JLabel nomePro;
    JLabel descriPro;
    JLabel precoPro;
    JLabel importPro;

    JButton salvarPro;
    JButton cancelarPro;

    //metodos produto
    DefaultTableModel modeloPro;

    //Paineis
    JFrame jFrame;
    JPanel clientePanel;
    JPanel funcionarioPanel;
    JPanel produtoPanel;


    public Tela() {

        jFrame = new JFrame();
        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        //painel Cliente
        clientePanel = new JPanel();
        clientePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcCli = new GridBagConstraints();

        pesquisarCli = new PlaceholderTextField("Pesquisar nome");
        gbcCli.gridx = 0;
        gbcCli.gridy = 0;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.weighty = 0;
        gbcCli.fill = GridBagConstraints.BOTH;
        gbcCli.anchor = GridBagConstraints.NORTHWEST;
        gbcCli.insets = new Insets(10, 7, 10, 0);
        clientePanel.add(pesquisarCli, gbcCli);

        adicionarCli = new JButton(" Adicionar ");
        gbcCli.gridx = 1;
        gbcCli.gridy = 0;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(10, 7, 10, 0);
        clientePanel.add(adicionarCli, gbcCli);

        removerCli = new JButton("Remover");
        gbcCli.gridx = 2;
        gbcCli.gridy = 0;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(10, 7, 10, 0);
        clientePanel.add(removerCli, gbcCli);

        maisNovo = new JButton(" Mais Novo ");
        gbcCli.gridx = 0;
        gbcCli.gridy = 1;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(0, 7, 0, 0);
        clientePanel.add(maisNovo, gbcCli);

        maisVelho = new JButton("Mais Velho");
        gbcCli.gridx = 1;
        gbcCli.gridy = 1;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(0, 7, 0, 0);
        clientePanel.add(maisVelho, gbcCli);

        acima60 = new JButton("Maiores de 60");
        gbcCli.gridx = 2;
        gbcCli.gridy = 1;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(0, 7, 0, 0);
        clientePanel.add(acima60, gbcCli);

        abaixo18 = new JButton("Menores de 18");
        gbcCli.gridx = 3;
        gbcCli.gridy = 1;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(0, 7, 0, 0);
        clientePanel.add(abaixo18, gbcCli);

        mediaIdade = new JButton("Média Idade");
        gbcCli.gridx = 4;
        gbcCli.gridy = 1;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 1;
        gbcCli.weightx = 0;
        gbcCli.fill = GridBagConstraints.NONE;
        gbcCli.insets = new Insets(0, 7, 0, 0);
        clientePanel.add(mediaIdade, gbcCli);

        // Dados da tabela
        modeloCli = new DefaultTableModel(
                new Object[]{"Nome", "Idade", "Endereço", "CPF", "Telefone"}, 0
        );

        listaCli = new JTable(modeloCli);
        listaCli.getTableHeader().setReorderingAllowed(false);
        listaCli.setDefaultEditor(Object.class, null);

        listaCli.getTableHeader().setResizingAllowed(false);

        scrollListaCli = new JScrollPane(listaCli);

        // Adiciona a tabela na parte esquerda
        gbcCli.gridx = 0;
        gbcCli.gridy = 2;
        gbcCli.gridwidth = 5;
        gbcCli.weightx = 1;
        gbcCli.weighty = 1;
        gbcCli.fill = GridBagConstraints.BOTH;
        gbcCli.insets = new Insets(10, 7, 0, 0);
        clientePanel.add(scrollListaCli, gbcCli);

        //Adiciona tabela na parte direita
        menuCli = new JPanel();
        menuCli.setLayout(new GridBagLayout());
        GridBagConstraints gbcCli2 = new GridBagConstraints();
        gbcCli.gridx = 5;
        gbcCli.gridy = 0;
        gbcCli.gridwidth = 1;
        gbcCli.gridheight = 3;
        gbcCli.weightx = 0.7;
        gbcCli.weighty = 1;
        gbcCli.fill = GridBagConstraints.BOTH;
        gbcCli.insets = new Insets(10, 10, 0, 0);
        clientePanel.add(menuCli, gbcCli);

        //campos do menu
        nomeCli = new JLabel("Insira nome: ");
        nomeCli.setFont(new Font("Arial", Font.BOLD, 12));
        gbcCli2.gridx = 0;
        gbcCli2.gridy = 0;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.anchor = GridBagConstraints.NORTHWEST;
        gbcCli2.insets = new Insets(0, 10, 0, 0);
        menuCli.add(nomeCli, gbcCli2);

        addNomeCli = new JTextField();
        gbcCli2.gridx = 1;
        gbcCli2.gridy = 0;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 1;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.BOTH;
        gbcCli2.insets = new Insets(0, 4, 0, 20);
        menuCli.add(addNomeCli, gbcCli2);

        idadeCli = new JLabel("Insira idade: ");
        idadeCli.setFont(new Font("Arial", Font.BOLD, 12));
        gbcCli2.gridx = 0;
        gbcCli2.gridy = 1;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.insets = new Insets(20, 10, 0, 0);
        menuCli.add(idadeCli, gbcCli2);

        addIdadeCli = new JTextField();
        gbcCli2.gridx = 1;
        gbcCli2.gridy = 1;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 1;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.BOTH;
        gbcCli2.insets = new Insets(20, 4, 0, 20);
        menuCli.add(addIdadeCli, gbcCli2);

        enderecoCli = new JLabel("   Endereço: ");
        enderecoCli.setFont(new Font("Arial", Font.BOLD, 12));
        gbcCli2.gridx = 0;
        gbcCli2.gridy = 2;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.insets = new Insets(20, 10, 0, 0);
        menuCli.add(enderecoCli, gbcCli2);

        addEnderecoCli = new JTextField();
        gbcCli2.gridx = 1;
        gbcCli2.gridy = 2;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 1;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.BOTH;
        gbcCli2.insets = new Insets(20, 4, 0, 20);
        menuCli.add(addEnderecoCli, gbcCli2);

        cpfCli = new JLabel("  Insira CPF: ");
        cpfCli.setFont(new Font("Arial", Font.BOLD, 12));
        gbcCli2.gridx = 0;
        gbcCli2.gridy = 3;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.insets = new Insets(20, 10, 0, 0);
        menuCli.add(cpfCli, gbcCli2);

        addCpfCli = new JTextField();
        gbcCli2.gridx = 1;
        gbcCli2.gridy = 3;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 1;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.BOTH;
        gbcCli2.insets = new Insets(20, 4, 0, 20);
        menuCli.add(addCpfCli, gbcCli2);

        telefoneCli = new JLabel("    Telefone: ");
        telefoneCli.setFont(new Font("Arial", Font.BOLD, 12));
        gbcCli2.gridx = 0;
        gbcCli2.gridy = 4;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.insets = new Insets(20, 10, 0, 0);
        menuCli.add(telefoneCli, gbcCli2);

        addTelefoneCli = new JTextField();
        gbcCli2.gridx = 1;
        gbcCli2.gridy = 4;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 1;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.BOTH;
        gbcCli2.insets = new Insets(20, 4, 0, 20);
        menuCli.add(addTelefoneCli, gbcCli2);

        salvarCli = new JButton("Salvar");
        gbcCli2.gridx = 0;
        gbcCli2.gridy = 5;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.insets = new Insets(40, 10, 0, 0);
        menuCli.add(salvarCli, gbcCli2);

        cancelarCli = new JButton("Cancelar");
        gbcCli2.gridx = 1;
        gbcCli2.gridy = 5;
        gbcCli2.gridwidth = 1;
        gbcCli2.gridheight = 1;
        gbcCli2.weightx = 0;
        gbcCli2.weighty = 0;
        gbcCli2.fill = GridBagConstraints.NONE;
        gbcCli2.insets = new Insets(40, 10, 0, 0);
        menuCli.add(cancelarCli, gbcCli2);


        //painel funcionario
        funcionarioPanel = new JPanel();
        funcionarioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcFun = new GridBagConstraints();

        pesquisarFun = new PlaceholderTextField("Pesquisar nome");
        gbcFun.gridx = 0;
        gbcFun.gridy = 0;
        gbcFun.gridwidth = 1;
        gbcFun.gridheight = 1;
        gbcFun.weightx = 1;
        gbcFun.weighty = 0;
        gbcFun.fill = GridBagConstraints.BOTH;
        gbcFun.anchor = GridBagConstraints.NORTHWEST;
        gbcFun.insets = new Insets(10, 7, 0, 0);
        funcionarioPanel.add(pesquisarFun, gbcFun);

        adicionarFun = new JButton("Adicionar");
        gbcFun.gridx = 1;
        gbcFun.gridy = 0;
        gbcFun.gridwidth = 1;
        gbcFun.gridheight = 1;
        gbcFun.weightx = 0;
        gbcFun.weighty = 0;
        gbcFun.fill = GridBagConstraints.NONE;
        gbcFun.insets = new Insets(10, 7, 0, 0);
        funcionarioPanel.add(adicionarFun, gbcFun);

        removerFun = new JButton("Remover");
        gbcFun.gridx = 2;
        gbcFun.gridy = 0;
        gbcFun.gridwidth = 1;
        gbcFun.gridheight = 1;
        gbcFun.weightx = 1;
        gbcFun.weighty = 0;
        gbcFun.fill = GridBagConstraints.NONE;
        gbcFun.insets = new Insets(10, 7, 0, 190);
        funcionarioPanel.add(removerFun, gbcFun);

        // Dados da tabela
        modeloFun = new DefaultTableModel(
                new Object[]{"Nome", "Idade", "Endereço", "Código", "Salário"}, 0
        );

        listaFun = new JTable(modeloFun);
        listaFun.getTableHeader().setReorderingAllowed(false);
        listaFun.setDefaultEditor(Object.class, null);

        listaFun.getTableHeader().setResizingAllowed(false);

        scrollListaFun = new JScrollPane(listaFun);

        // Adiciona a tabela na parte esquerda
        gbcFun.gridx = 0;
        gbcFun.gridy = 1;
        gbcFun.gridwidth = 3;
        gbcFun.gridheight = 1;
        gbcFun.weightx = 0;
        gbcFun.weighty = 1;
        gbcFun.fill = GridBagConstraints.BOTH;
        gbcFun.insets = new Insets(10, 7, 0, 0);
        funcionarioPanel.add(scrollListaFun, gbcFun);

        //tabela da direita
        menuFun = new JPanel();
        menuFun.setLayout(new GridBagLayout());
        GridBagConstraints gbcFun2 = new GridBagConstraints();
        gbcFun.gridx = 3;
        gbcFun.gridy = 0;
        gbcFun.gridwidth = 1;
        gbcFun.gridheight = 3;
        gbcFun.weightx = 0.09;
        gbcFun.weighty = 1;
        gbcFun.fill = GridBagConstraints.BOTH;
        gbcFun.insets = new Insets(10, 10, 0, 0);
        funcionarioPanel.add(menuFun, gbcFun);

        //campos do menu funcionario
        nomeFun = new JLabel("Insira nome: ");
        nomeFun.setFont(new Font("Arial", Font.BOLD, 12));
        gbcFun2.gridx = 0;
        gbcFun2.gridy = 0;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.anchor = GridBagConstraints.NORTHWEST;
        gbcFun2.insets = new Insets(0, 10, 0, 0);
        menuFun.add(nomeFun, gbcFun2);

        addNomeFun = new JTextField();
        gbcFun2.gridx = 1;
        gbcFun2.gridy = 0;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 1;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.BOTH;
        gbcFun2.insets = new Insets(0, 10, 0, 20);
        menuFun.add(addNomeFun, gbcFun2);

        idadeFun = new JLabel("Insira idade: ");
        idadeFun.setFont(new Font("Arial", Font.BOLD, 12));
        gbcFun2.gridx = 0;
        gbcFun2.gridy = 1;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.insets = new Insets(20, 10, 0, 0);
        menuFun.add(idadeFun, gbcFun2);

        addIdadeFun = new JTextField();
        gbcFun2.gridx = 1;
        gbcFun2.gridy = 1;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 1;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.BOTH;
        gbcFun2.insets = new Insets(20, 10, 0, 20);
        menuFun.add(addIdadeFun, gbcFun2);

        enderecoFun = new JLabel("    Endereço:");
        enderecoFun.setFont(new Font("Arial", Font.BOLD, 12));
        gbcFun2.gridx = 0;
        gbcFun2.gridy = 2;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.insets = new Insets(20, 10, 0, 0);
        menuFun.add(enderecoFun, gbcFun2);

        addEnderecoFun = new JTextField();
        gbcFun2.gridx = 1;
        gbcFun2.gridy = 2;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 1;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.BOTH;
        gbcFun2.insets = new Insets(20, 10, 0, 20);
        menuFun.add(addEnderecoFun, gbcFun2);

        codigoFun = new JLabel("Insira código:");
        codigoFun.setFont(new Font("Arial", Font.BOLD, 12));
        gbcFun2.gridx = 0;
        gbcFun2.gridy = 3;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.insets = new Insets(20, 10, 0, 0);
        menuFun.add(codigoFun, gbcFun2);

        addCodigoFun = new JTextField();
        gbcFun2.gridx = 1;
        gbcFun2.gridy = 3;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 1;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.BOTH;
        gbcFun2.insets = new Insets(20, 10, 0, 20);
        menuFun.add(addCodigoFun, gbcFun2);

        salarioFun = new JLabel("          Salário:");
        salarioFun.setFont(new Font("Arial", Font.BOLD, 12));
        gbcFun2.gridx = 0;
        gbcFun2.gridy = 4;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.insets = new Insets(20, 10, 0, 0);
        menuFun.add(salarioFun, gbcFun2);

        addSalario = new JTextField();
        gbcFun2.gridx = 1;
        gbcFun2.gridy = 4;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 1;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.BOTH;
        gbcFun2.insets = new Insets(20, 10, 0, 20);
        menuFun.add(addSalario, gbcFun2);

        salvarFun = new JButton("Salvar");
        gbcFun2.gridx = 0;
        gbcFun2.gridy = 5;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.insets = new Insets(40, 10, 0, 0);
        menuFun.add(salvarFun, gbcFun2);

        cancelarFun = new JButton("Cancelar");
        gbcFun2.gridx = 1;
        gbcFun2.gridy = 5;
        gbcFun2.gridwidth = 1;
        gbcFun2.gridheight = 1;
        gbcFun2.weightx = 0;
        gbcFun2.weighty = 0;
        gbcFun2.fill = GridBagConstraints.NONE;
        gbcFun2.insets = new Insets(40, 10, 0, 0);
        menuFun.add(cancelarFun, gbcFun2);


        //painel produto
        produtoPanel = new JPanel();
        produtoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcPro = new GridBagConstraints();

        pesquisarNomePro = new PlaceholderTextField("Pesquisar nome");
        gbcPro.gridx = 0;
        gbcPro.gridy = 0;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.BOTH;
        gbcPro.anchor = GridBagConstraints.NORTHWEST;
        gbcPro.insets = new Insets(10, 7, 0, 0);
        produtoPanel.add(pesquisarNomePro, gbcPro);

        pesquisarDescriPro = new PlaceholderTextField("Pesquisar descrição");
        gbcPro.gridx = 1;
        gbcPro.gridy = 0;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.BOTH;
        gbcPro.insets = new Insets(10, 7, 0, 0);
        produtoPanel.add(pesquisarDescriPro, gbcPro);

        pesquisarPrecoPro = new PlaceholderTextField("Pesquisar preço");
        gbcPro.gridx = 2;
        gbcPro.gridy = 0;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.BOTH;
        gbcPro.insets = new Insets(10, 7, 0, 0);
        produtoPanel.add(pesquisarPrecoPro, gbcPro);

        adicionarPro = new JButton("    Adicionar    ");
        gbcPro.gridx = 3;
        gbcPro.gridy = 0;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.NONE;
        gbcPro.insets = new Insets(10, 7, 0, 0);
        produtoPanel.add(adicionarPro, gbcPro);

        removerPro = new JButton("Remover");
        gbcPro.gridx = 4;
        gbcPro.gridy = 0;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 1;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.NONE;
        gbcPro.insets = new Insets(10, 7, 0, 4);
        produtoPanel.add(removerPro, gbcPro);

        maisCaroPro = new JButton(" Mais Caro ");
        gbcPro.gridx = 0;
        gbcPro.gridy = 1;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.NONE;
        gbcPro.insets = new Insets(10, 7, 0, 4);
        produtoPanel.add(maisCaroPro, gbcPro);

        maisBaratoPro = new JButton("   Mais Barato   ");
        gbcPro.gridx = 1;
        gbcPro.gridy = 1;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.NONE;
        gbcPro.insets = new Insets(10, 7, 0, 4);
        produtoPanel.add(maisBaratoPro, gbcPro);

        mediaPrecoPro = new JButton("Media Preço");
        gbcPro.gridx = 2;
        gbcPro.gridy = 1;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.NONE;
        gbcPro.insets = new Insets(10, 7, 0, 4);
        produtoPanel.add(mediaPrecoPro, gbcPro);

        qtdAcimaMedia = new JButton("Preços Acima");
        gbcPro.gridx = 3;
        gbcPro.gridy = 1;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 0;
        gbcPro.fill = GridBagConstraints.NONE;
        gbcPro.insets = new Insets(10, 7, 0, 4);
        produtoPanel.add(qtdAcimaMedia, gbcPro);

        // Dados da tabela
        modeloPro = new DefaultTableModel(
                new Object[]{"Nome", "Descrição", "Preço", "Importado", "Código"}, 0
        );

        listaPro = new JTable(modeloPro);

        listaPro.getTableHeader().setResizingAllowed(false);
        listaPro.getTableHeader().setReorderingAllowed(false);
        listaPro.setDefaultEditor(Object.class, null);

        scrollListaPro = new JScrollPane(listaPro);

        // Adiciona a tabela na parte esquerda
        gbcPro.gridx = 0;
        gbcPro.gridy = 2;
        gbcPro.gridwidth = 5;
        gbcPro.gridheight = 1;
        gbcPro.weightx = 0;
        gbcPro.weighty = 1;
        gbcPro.fill = GridBagConstraints.BOTH;
        gbcPro.insets = new Insets(10, 7, 0, 0);
        produtoPanel.add(scrollListaPro, gbcPro);

        //tabela da direita
        menuPro = new JPanel();
        menuPro.setLayout(new GridBagLayout());
        GridBagConstraints gbcPro2 = new GridBagConstraints();
        gbcPro.gridx = 5;
        gbcPro.gridy = 0;
        gbcPro.gridwidth = 1;
        gbcPro.gridheight = 3;
        gbcPro.weightx = 0.1;
        gbcPro.weighty = 1;
        gbcPro.fill = GridBagConstraints.BOTH;
        gbcPro.insets = new Insets(10, 10, 0, 0);
        produtoPanel.add(menuPro, gbcPro);

        //campos do menu produto
        nomePro = new JLabel("      Insira nome:");
        nomePro.setFont(new Font("Arial", Font.BOLD, 12));
        gbcPro2.gridx = 0;
        gbcPro2.gridy = 0;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 0;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.NONE;
        gbcPro2.anchor = GridBagConstraints.NORTHWEST;
        gbcPro2.insets = new Insets(0, 0, 0, 0);
        menuPro.add(nomePro, gbcPro2);

        addNomePro = new JTextField();
        gbcPro2.gridx = 1;
        gbcPro2.gridy = 0;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 1;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.BOTH;
        gbcPro2.insets = new Insets(0, 0, 0, 20);
        menuPro.add(addNomePro, gbcPro2);

        descriPro = new JLabel("         Descrição:");
        descriPro.setFont(new Font("Arial", Font.BOLD, 12));
        gbcPro2.gridx = 0;
        gbcPro2.gridy = 1;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 0;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.NONE;
        gbcPro2.insets = new Insets(20, 0, 0, 0);
        menuPro.add(descriPro, gbcPro2);

        addDescriPro = new JTextField();
        gbcPro2.gridx = 1;
        gbcPro2.gridy = 1;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 1;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.BOTH;
        gbcPro2.insets = new Insets(20, 0, 0, 20);
        menuPro.add(addDescriPro, gbcPro2);

        precoPro = new JLabel("      Insira preço:");
        precoPro.setFont(new Font("Arial", Font.BOLD, 12));
        gbcPro2.gridx = 0;
        gbcPro2.gridy = 2;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 0;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.NONE;
        gbcPro2.insets = new Insets(20, 0, 0, 0);
        menuPro.add(precoPro, gbcPro2);

        addPrecoPro = new JTextField();
        gbcPro2.gridx = 1;
        gbcPro2.gridy = 2;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 1;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.BOTH;
        gbcPro2.insets = new Insets(20, 0, 0, 20);
        menuPro.add(addPrecoPro, gbcPro2);

        importPro = new JLabel("Importado [s/n]: ");
        importPro.setFont(new Font("Arial", Font.BOLD, 12));
        gbcPro2.gridx = 0;
        gbcPro2.gridy = 3;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 0;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.NONE;
        gbcPro2.insets = new Insets(20, 0, 0, 0);
        menuPro.add(importPro, gbcPro2);

        addImportPro = new JTextField();
        gbcPro2.gridx = 1;
        gbcPro2.gridy = 3;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 1;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.BOTH;
        gbcPro2.insets = new Insets(20, 0, 0, 20);
        menuPro.add(addImportPro, gbcPro2);

        salvarPro = new JButton("Salvar");
        gbcPro2.gridx = 0;
        gbcPro2.gridy = 4;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 0;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.NONE;
        gbcPro2.insets = new Insets(80, 10, 0, 0);
        menuPro.add(salvarPro, gbcPro2);

        cancelarPro = new JButton("Cancelar");
        gbcPro2.gridx = 1;
        gbcPro2.gridy = 4;
        gbcPro2.gridwidth = 1;
        gbcPro2.gridheight = 1;
        gbcPro2.weightx = 0;
        gbcPro2.weighty = 0;
        gbcPro2.fill = GridBagConstraints.NONE;
        gbcPro2.insets = new Insets(80, 0, 0, 0);
        menuPro.add(cancelarPro, gbcPro2);

        menuCli.setVisible(false);
        menuFun.setVisible(false);
        menuPro.setVisible(false);

        tabbedPane.addTab("Cliente", clientePanel);
        tabbedPane.addTab("Funcionario", funcionarioPanel);
        tabbedPane.addTab("Produto", produtoPanel);


        //metodos pros botoes e placeholders
        adicionarCli.addActionListener(this::setAdicionarCli);
        removerCli.addActionListener(this::setRemoverCli);
        cancelarCli.addActionListener(this::setCancelarCli);
        salvarCli.addActionListener(this::setSalvarCli);
        pesquisarCli.addActionListener(this::setPesquisarCli);
        maisNovo.addActionListener(this::setMaisNovo);
        maisVelho.addActionListener(this::setMaisVelho);
        acima60.addActionListener(this::setAcima60);
        abaixo18.addActionListener(this::setAbaixo18);
        mediaIdade.addActionListener(this::setMediaIdade);

        adicionarFun.addActionListener(this::setAdicionarFun);
        removerFun.addActionListener(this::setRemoverFun);
        cancelarFun.addActionListener(this::setCancelarFun);
        salvarFun.addActionListener(this::setSalvarFun);
        pesquisarFun.addActionListener(this::setPesquisarFun);

        adicionarPro.addActionListener(this::setAdicionarPro);
        removerPro.addActionListener(this::setRemoverPro);
        cancelarPro.addActionListener(this::setCancelarPro);
        salvarPro.addActionListener(this::setSalvarPro);
        pesquisarNomePro.addActionListener(this::setPesquisarNomePro);
        pesquisarDescriPro.addActionListener(this::setPesquisarDescriPro);
        pesquisarPrecoPro.addActionListener(this::setPesquisarPrecoPro);
        maisCaroPro.addActionListener(this::setMaisCaroPro);
        maisBaratoPro.addActionListener(this::setMaisBaratoPro);
        mediaPrecoPro.addActionListener(this::setMediaPrecoPro);
        qtdAcimaMedia.addActionListener(this::setQtdAcimaMedia);

        //tela recebe os paineis
        jFrame.add(tabbedPane, BorderLayout.CENTER);

        jFrame.setVisible(true);
    }

    public void setAdicionarCli(ActionEvent e) {
        menuCli.setVisible(true);
    }

    public void setCancelarCli(ActionEvent e) {
        addNomeCli.setText("");
        addIdadeCli.setText("");
        addEnderecoCli.setText("");
        addCpfCli.setText("");
        addTelefoneCli.setText("");
        menuCli.setVisible(false);
    }

    public void setAdicionarFun(ActionEvent e) {
        menuFun.setVisible(true);
    }

    public void setCancelarFun(ActionEvent e) {
        addNomeFun.setText("");
        addIdadeFun.setText("");
        addEnderecoFun.setText("");
        addCodigoFun.setText("");
        addSalario.setText("");
        menuFun.setVisible(false);
    }

    public void setAdicionarPro(ActionEvent e) {
        menuPro.setVisible(true);
    }

    public void setCancelarPro(ActionEvent e) {
        addNomePro.setText("");
        addDescriPro.setText("");
        addPrecoPro.setText("");
        addImportPro.setText("");
        menuPro.setVisible(false);
    }

    public void setRemoverCli(ActionEvent e) {
        int selectedRowCli = listaCli.getSelectedRow();
        if(selectedRowCli != -1) {
            String cpfSelected = (String) listaCli.getValueAt(listaCli.getSelectedRow(), 3);
            Cliente clienteParaRemover = null;

            for (Cliente cliente : arrayListaCli) {
                if (cliente.cpf.startsWith(cpfSelected)) {
                        clienteParaRemover = cliente;
                }
            }

            if (clienteParaRemover != null) {
                arrayListaCli.remove(clienteParaRemover);
            }
            modeloCli.removeRow(selectedRowCli);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Selecione um item da lista",
                    "Erro ao remover",
                    JOptionPane.ERROR_MESSAGE
                    );
        }
    }

    public void setRemoverFun(ActionEvent e) {
        int selectedRowFun = listaFun.getSelectedRow();
        if(selectedRowFun != -1) {
            String codigoSelected = (String) listaFun.getValueAt(listaFun.getSelectedRow(), 3);
            Funcionario funcionarioParaRemover = null;
            for (Funcionario funcionario : arrayListaFun) {

                if(funcionario.codigoDeRegistro.startsWith(codigoSelected)) {
                    funcionarioParaRemover = funcionario;
                }
            }
            if (funcionarioParaRemover != null) {
                arrayListaFun.remove(funcionarioParaRemover);
            }
            modeloFun.removeRow(selectedRowFun);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Selecione um item da lista",
                    "Erro ao remover",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void setRemoverPro(ActionEvent e) {
        int selectedRowPro = listaPro.getSelectedRow();
        if(selectedRowPro != -1) {
            int codigoSelected = (int) listaPro.getValueAt(listaPro.getSelectedRow(), 4);
            Produto produtoParaRemover = null;
            for (Produto produto : arrayListaPro) {

                if(produto.codigoProduto == (codigoSelected)) {
                    produtoParaRemover = produto;
                }
            }
            if (produtoParaRemover != null) {
                arrayListaPro.remove(produtoParaRemover);
            }
            modeloPro.removeRow(selectedRowPro);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Selecione um item da lista",
                    "Erro ao remover",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void setSalvarCli(ActionEvent e) {
        int exception = 0;

        //erro se o nome for vazio
        String nomeInseridoCli = addNomeCli.getText();
        if (nomeInseridoCli.isEmpty()) {
            exception++;
        }
        //erro se idade for vazio ou não for um numero, erro se for menor ou igual a 0
        String idadeInseridaCliString = addIdadeCli.getText();
        Integer idadeInseridaCli = 0;
        if (idadeInseridaCliString.isEmpty()) {
            exception++;
        }
        else if(idadeInseridaCliString.length() > 3) {
            exception++;
        }
        else {
            try {
                idadeInseridaCli = Integer.parseInt(idadeInseridaCliString);
            } catch (NumberFormatException a) {
                exception++;
            }
            if (idadeInseridaCli <= 0) {
                exception++;
            }
        }
        //erro se endereco for vazio
        String enderecoInseridoCli = addEnderecoCli.getText();
        if (enderecoInseridoCli.isEmpty()) {
            exception++;
        }
        //erro se cpf for vazio/ nao tiver exatamente 11 digitos/ nao ser apenas numeros inteiros
        String cpfInseridoCli = addCpfCli.getText();
        Long cpfValido=0l;
        if (cpfInseridoCli.isEmpty()) {
            exception++;
        }
        else if (cpfInseridoCli.length() != 11) {
            exception++;
        }
        else {
            try {
                cpfValido = Long.parseLong(cpfInseridoCli);
            } catch (NumberFormatException a) {
                exception++;
            }
            if(cpfValido<=0) {
                exception++;
            }
        }

        //erro se telefone for vazio/ nao tiver exatamente 8 digitos/ nao ser apenas numeros inteiros
        String telefoneInseridoCli = addTelefoneCli.getText();
        Long telefoneValido=0l;
        if (telefoneInseridoCli.isEmpty())
        {
            exception++;
        }
        else if (telefoneInseridoCli.length() < 8 || telefoneInseridoCli.length() > 9) {
            exception++;
        }
        else {
            try {
                telefoneValido = Long.parseLong(telefoneInseridoCli);
            } catch (NumberFormatException a) {
                exception++;
            }
            if(telefoneValido<=0) {
                exception++;
            }
        }

        if(exception==0) {
            int cpfUnico=0;
            for(Cliente cliente :arrayListaCli) {
                if(cliente.cpf.equals(cpfInseridoCli)) {
                    cpfUnico++;
                }
            }
            if(cpfUnico==0) {
                Cliente clNovo = new Cliente(
                        nomeInseridoCli,
                        idadeInseridaCli,
                        enderecoInseridoCli,
                        cpfInseridoCli,
                        telefoneInseridoCli);
                arrayListaCli.add(clNovo);

                modeloCli.addRow(new Object[]{
                        clNovo.nome, clNovo.idade, clNovo.endereco, clNovo.cpf, clNovo.telefone}
                );

                addNomeCli.setText("");
                addIdadeCli.setText("");
                addEnderecoCli.setText("");
                addCpfCli.setText("");
                addTelefoneCli.setText("");
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Já existe um cliente com esse CPF",
                        "Erro ao salvar Cliente",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Verifique se há algum campo vazio ou que não faça sentido:\n" +
                            "Idade só aceita números inteiros positivos com 3 digitos ou menos\n" +
                            "Cpf só aceita um número inteiro de 11 dígitos\n" +
                            "Telefone só aceita um número inteiro de 8 ou 9 dígitos",
                    "Erro ao salvar Cliente",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setSalvarFun(ActionEvent e) {
        int exception=0;

        //erro se o nome for vazio
        String nomeInseridoFun = addNomeFun.getText();
        if (nomeInseridoFun.isEmpty()) {
            exception++;
        }
        //erro se idade for vazio ou não for um numero, erro se for menor ou igual a 0
        String idadeInseridaFunString = addIdadeFun.getText();
        Integer idadeInseridaFun=0;
        if(idadeInseridaFunString.isEmpty()) {
            exception++;
        }
        else if(idadeInseridaFunString.length() > 3) {
            exception++;
        }
        else {
            try {
                idadeInseridaFun = Integer.parseInt(idadeInseridaFunString);
            } catch(NumberFormatException a) {
                exception++;
            }
            if(idadeInseridaFun<=0) {
                exception++;
            }
        }
        //erro se endereco for vazio
        String enderecoInseridoFun = addEnderecoFun.getText();
        if(enderecoInseridoFun.isEmpty()) {
            exception++;
        }
        //erro se o codigo do funcionario for vazio
        String codigoInseridoFun = addCodigoFun.getText();
        if(codigoInseridoFun.isEmpty()) {
            exception++;
        }
        //erro se o salario for vazio/ não for numero/ menor ou igual a 0
        String salarioInseridoFunString = addSalario.getText();
        double salarioInseridoFun=0;
        if(salarioInseridoFunString.isEmpty()) {
            exception++;
        }
        else {
            try {
                salarioInseridoFun = Double.parseDouble(salarioInseridoFunString);
            } catch (NumberFormatException a) {
                exception++;
            }
            if(salarioInseridoFun<=0) {
                exception++;
            }
        }
        if(exception==0) {
            int codigoValido=0;
            //erro se ja tiver um funcionario com esse codigo de registro
            for(Funcionario funcionario : arrayListaFun) {
                if(funcionario.codigoDeRegistro.equals(codigoInseridoFun)) {
                    codigoValido++;
                }
            }
                if (codigoValido==0) {
                    Funcionario fNovo = new Funcionario(
                            nomeInseridoFun,
                            idadeInseridaFun,
                            enderecoInseridoFun,
                            codigoInseridoFun,
                            salarioInseridoFun);
                    arrayListaFun.add(fNovo);

                    modeloFun.addRow(new Object[]{
                            fNovo.nome, fNovo.idade, fNovo.endereco, fNovo.codigoDeRegistro, fNovo.salario}
                    );

                    addNomeFun.setText("");
                    addIdadeFun.setText("");
                    addEnderecoFun.setText("");
                    addCodigoFun.setText("");
                    addSalario.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Já existe um funcionário com esse código",
                            "Erro ao salvar Funcionário",
                            JOptionPane.ERROR_MESSAGE);
                }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Verifique se há algum campo vazio ou que não faça sentido:\n" +
                            "Idade só aceita números inteiros positivos com 3 digitos ou menos\n" +
                            "Salário só aceita números positivos",
                    "Erro ao salvar Funcionário",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setSalvarPro(ActionEvent e) {
        int exception=0;

        //Erro se o nome for vazio
        String nomeInseridoPro = addNomePro.getText();
        if(nomeInseridoPro.isEmpty()){
            exception++;
        }
        //Erro se a descricao for vazia
        String descriInseridaPro = addDescriPro.getText();
        if(descriInseridaPro.isEmpty()){
            exception++;
        }
        //Erro se o preco for uma letra ou vazio, caso seja um numero, erro se for menor ou igual a 0
        String precoInseridoProString = addPrecoPro.getText();
        double precoInseridoPro = 0;
        if(precoInseridoProString.isEmpty()){
            exception++;
        }
        else {
            try {
                precoInseridoPro = Double.parseDouble(precoInseridoProString);
            } catch (NumberFormatException a) {
                exception++;
            }
            if (precoInseridoPro <= 0) {
                exception++;
            }
        }
        //Erro se o importado não for "s" ou "n"
        String importadeInseridoProString = addImportPro.getText();
        boolean importadoInseridoPro=false;
        if(Objects.equals(importadeInseridoProString, "s")) {
            importadoInseridoPro = true;
        }
        else if(Objects.equals(importadeInseridoProString, "n")) {
            importadoInseridoPro = false;
        }
        else {
            exception++;
        }
        //se exception for 0, ele adiciona normalmente, se não, exibe uma mensagem de erro
        if(exception==0) {
            Produto pNovo = new Produto(
                    nomeInseridoPro,
                    descriInseridaPro,
                    precoInseridoPro,
                    importadoInseridoPro);
            arrayListaPro.add(pNovo);
            modeloPro.addRow(new Object[]{
                    pNovo.nome, pNovo.descricao, pNovo.preco, pNovo.importado, pNovo.codigoProduto}
            );
            addNomePro.setText("");
            addDescriPro.setText("");
            addPrecoPro.setText("");
            addImportPro.setText("");
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Verifique se há algum campo vazio ou que não faça sentido:\n" +
                            "Preço só aceita números positivos\n" +
                            "Importado só aceita 's' ou 'n'",
                    "Erro ao salvar Produto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPesquisarCli(ActionEvent e) {

        if(pesquisarCli.getText().isEmpty()) {
            modeloCli.setRowCount(0);
            for(Cliente cliente : arrayListaCli){
                modeloCli.addRow(new Object[]{
                        cliente.nome,
                        cliente.idade,
                        cliente.endereco,
                        cliente.cpf,
                        cliente.telefone}
                );
            }
        }
        else {
            modeloCli.setRowCount(0);
            for(Cliente cliente : arrayListaCli){
                if (cliente.nome.startsWith(pesquisarCli.getText())) {

                    modeloCli.addRow(new Object[]{
                            cliente.nome,
                            cliente.idade,
                            cliente.endereco,
                            cliente.cpf,
                            cliente.telefone}
                    );
                }
            }
        }
    }

    public void setMaisNovo(ActionEvent e) {
        pesquisarCli.setText(null);
        modeloCli.setRowCount(0);
        if(arrayListaCli.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há clientes",
                    "Erro ao exibir cliente mais novo",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            Cliente cliente = GerenciadorClientes.getClienteMaisNovo(arrayListaCli);

                    modeloCli.addRow(new Object[]{
                            cliente.nome,
                            cliente.idade,
                            cliente.endereco,
                            cliente.cpf,
                            cliente.telefone}
                    );


        }
    }

    public void setMaisVelho(ActionEvent e) {
        pesquisarCli.setText(null);
        modeloCli.setRowCount(0);
        if(arrayListaCli.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há clientes",
                    "Erro ao exibir cliente mais velho",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            Cliente cliente = GerenciadorClientes.getCliMaisVelho(arrayListaCli);

                    modeloCli.addRow(new Object[]{
                            cliente.nome,
                            cliente.idade,
                            cliente.endereco,
                            cliente.cpf,
                            cliente.telefone}
                    );


        }
    }

    public void setAcima60(ActionEvent e) {
        pesquisarCli.setText(null);
        modeloCli.setRowCount(0);
        if(arrayListaCli.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há clientes",
                    "Erro ao exibir clientes maiores de 60",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            for (Cliente cliente : arrayListaCli) {
                if (cliente.idade >= 60) {
                    modeloCli.addRow(new Object[]{
                            cliente.nome,
                            cliente.idade,
                            cliente.endereco,
                            cliente.cpf,
                            cliente.telefone});
                }
            }
        }
    }

    public void setAbaixo18(ActionEvent e) {
        pesquisarCli.setText(null);
        modeloCli.setRowCount(0);
        if(arrayListaCli.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há clientes",
                    "Erro ao exibir clientes menores de 18",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            for (Cliente cliente : arrayListaCli) {
                if (cliente.idade < 18) {
                    modeloCli.addRow(new Object[]{
                            cliente.nome,
                            cliente.idade,
                            cliente.endereco,
                            cliente.cpf,
                            cliente.telefone});
                }
            }
        }
    }

    public void setMediaIdade(ActionEvent e) {
        double mediaIdade = GerenciadorClientes.getMediaIdade(arrayListaCli);
        if(arrayListaCli.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Não há clientes",
                    "Erro ao calcular a média de idade",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Média de idade dos clientes: " + mediaIdade);
        }
    }

    public void setPesquisarFun(ActionEvent e) {

        if(pesquisarFun.getText().isEmpty()) {
            modeloFun.setRowCount(0);
            for(Funcionario funcionario : arrayListaFun){
                modeloFun.addRow(new Object[]{
                        funcionario.nome,
                        funcionario.idade,
                        funcionario.endereco,
                        funcionario.codigoDeRegistro,
                        funcionario.salario}
                );
            }
        }
        else {
            modeloFun.setRowCount(0);
            for(Funcionario funcionario : arrayListaFun){
                if (funcionario.nome.startsWith(pesquisarFun.getText())) {

                    modeloFun.addRow(new Object[]{
                            funcionario.nome,
                            funcionario.idade,
                            funcionario.endereco,
                            funcionario.codigoDeRegistro,
                            funcionario.salario}
                    );
                }
            }
        }
    }

    public void setPesquisarNomePro(ActionEvent e) {

        pesquisarDescriPro.setText(null);
        pesquisarPrecoPro.setText(null);
        if(pesquisarNomePro.getText().isEmpty()) {
            modeloPro.setRowCount(0);
            for(Produto produto : arrayListaPro){
                modeloPro.addRow(new Object[]{
                        produto.nome,
                        produto.descricao,
                        produto.preco,
                        produto.importado,
                        produto.codigoProduto}
                );
            }
        }
        else {
            modeloPro.setRowCount(0);
            for(Produto produto : arrayListaPro){
                if (produto.nome.startsWith(pesquisarNomePro.getText())) {

                    modeloPro.addRow(new Object[]{
                            produto.nome,
                            produto.descricao,
                            produto.preco,
                            produto.importado,
                            produto.codigoProduto}
                    );
                }
            }
        }
    }

    public void setPesquisarDescriPro(ActionEvent e) {

        pesquisarNomePro.setText(null);
        pesquisarPrecoPro.setText(null);
        if(pesquisarDescriPro.getText().isEmpty()) {
            modeloPro.setRowCount(0);
            for(Produto produto : arrayListaPro){
                modeloPro.addRow(new Object[]{
                        produto.nome,
                        produto.descricao,
                        produto.preco,
                        produto.importado,
                        produto.codigoProduto}
                );
            }
        }
        else {
            modeloPro.setRowCount(0);
            for(Produto produto : arrayListaPro){
                if (produto.descricao.startsWith(pesquisarDescriPro.getText())) {

                    modeloPro.addRow(new Object[]{
                            produto.nome,
                            produto.descricao,
                            produto.preco,
                            produto.importado,
                            produto.codigoProduto}
                    );
                }
            }
        }
    }

    public void setPesquisarPrecoPro(ActionEvent e) {

        pesquisarNomePro.setText(null);
        pesquisarDescriPro.setText(null);
        if(pesquisarPrecoPro.getText().isEmpty()) {
            modeloPro.setRowCount(0);
            for(Produto produto : arrayListaPro){
                modeloPro.addRow(new Object[]{
                        produto.nome,
                        produto.descricao,
                        produto.preco,
                        produto.importado,
                        produto.codigoProduto}
                );
            }
        }
        else {
            modeloPro.setRowCount(0);
            for(Produto produto : arrayListaPro){
                if (produto.preco == Double.parseDouble(pesquisarPrecoPro.getText())) {
                    modeloPro.addRow(new Object[]{
                            produto.nome,
                            produto.descricao,
                            produto.preco,
                            produto.importado,
                            produto.codigoProduto}
                    );
                }
            }
        }
    }

    public void setMaisCaroPro(ActionEvent e) {
        pesquisarDescriPro.setText(null);
        pesquisarPrecoPro.setText(null);
        pesquisarNomePro.setText(null);
        modeloPro.setRowCount(0);

        if(arrayListaPro.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há produtos",
                    "Erro ao exibir produto mais caro",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {

            Produto produtoMaisCaro = GerenciadorProdutos.getProdMaisCaro(arrayListaPro);

            modeloPro.addRow(new Object[]{
                            produtoMaisCaro.nome,
                            produtoMaisCaro.descricao,
                            produtoMaisCaro.preco,
                            produtoMaisCaro.importado,
                            produtoMaisCaro.codigoProduto}
                    );

        }
    }

    public void setMaisBaratoPro(ActionEvent e) {
        pesquisarDescriPro.setText(null);
        pesquisarPrecoPro.setText(null);
        pesquisarNomePro.setText(null);
        modeloPro.setRowCount(0);

        if(arrayListaPro.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não há produtos",
                    "Erro ao exibir produto mais barato",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            Produto produtoMaisBarato = GerenciadorProdutos.getProdutoMaisBarato(arrayListaPro);

            modeloPro.addRow(new Object[]{
                            produtoMaisBarato.nome,
                            produtoMaisBarato.descricao,
                            produtoMaisBarato.preco,
                            produtoMaisBarato.importado,
                            produtoMaisBarato.codigoProduto}
                    );


        }
    }

    public void setMediaPrecoPro(ActionEvent e) {
        double mediaPreco = GerenciadorProdutos.calcularMediaPreco(arrayListaPro);
        if(arrayListaPro.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Não há produtos",
                    "Erro ao calcular a média de preço",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Média de preço dos produtos: " + mediaPreco);
        }
    }

    public void setQtdAcimaMedia(ActionEvent e) {
        double mediaPreco = GerenciadorProdutos.calcularMediaPreco(arrayListaPro);

        if(arrayListaPro.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Não há produtos",
                    "Erro ao contabilizar produtos acima da média",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            modeloPro.setRowCount(0);
            for (Produto produto : arrayListaPro) {
                if (produto.preco > mediaPreco) {
                    modeloPro.addRow(new Object[]{
                            produto.nome,
                            produto.descricao,
                            produto.preco,
                            produto.importado,
                            produto.codigoProduto}
                    );
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tela::new);
    }
}
