package TDA;

public interface ConjuntoTDA {
	public void inicializarConjunto();
	public void agregar(int numero);
	public int elegir();
	public void sacar(int numero);
	public boolean conjuntoVacio();
	public boolean pertenece(int numero);
	public boolean todosPertenecen(ConjuntoTDA X);
	public void sacarTodos(ConjuntoTDA X);
}
