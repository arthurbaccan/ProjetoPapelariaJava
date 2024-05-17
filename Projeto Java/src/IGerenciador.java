public interface IGerenciador<T> {

    void adicionar(T objeto);
    void remover(T objeto);
    void mostrarTodos();
    void mostrarComandos();
}
