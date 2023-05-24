package TDA;

public interface ABBTDA {
	public void inicializarArbol();
	public void agregarElemento(int x); // El arbol debe estar inicializado
	public void eliminarElemento(int x); // El arbol debe estar inicializado
	public int raiz(); // El arbol debe estar inicializado y no vacio
	public ABBTDA hijoIzquierdo(); // El arbol debe estar inicializado y no vacio
	public ABBTDA hijoDerecho(); // El arbol debe estar inicializado y no vacio
	public boolean arbolVacio(); // El arbol debe estar inicializado	
}

