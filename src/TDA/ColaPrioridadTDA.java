package TDA;

public interface ColaPrioridadTDA {

	public void inicializarCola();
	public void acolarPrioridad(int numero, int prioridad); // La cola se encuentra inicializada.
	public void desacolar(); // La cola esta inicializada y no esta vacia.
	public int primero(); // La cola esta inicializada y no esta vacia.
	public int prioridad(); // La cola esta inicializa y no esta vacia.
	public boolean colaVacia(); // La cola esta inicializada.
	
	
}
