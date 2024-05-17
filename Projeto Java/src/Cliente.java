public class Cliente extends Pessoa{
    public Cliente(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    @Override
    public void exibir() {
        System.out.println(this);
    }
}
