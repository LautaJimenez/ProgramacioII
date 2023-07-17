package TDA;

public interface GrafoTDA {
	public void inicializarGrafo();
	public void agregarVertice(int v);
	public void eliminarVertice(int v);
	public ConjuntoTDA vertices();
	public void agregarArista(int v1, int v2, int peso);
	public void eliminarArista(int v1, int v2);
	public boolean existeArista(int v1, int v2);
	public int pesoArista(int v1, int v2);
}

