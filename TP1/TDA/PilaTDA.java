package TDA;

public interface PilaTDA {
	
	public void inicializarPila(); // No hay precondicion.
	public void apilar(int numero); // La pila debe estar inicializada.
	public void apilar2(int numero); // La pila debe estar inicializada.
	public void desapilar(); // La pila debe estar inicializada y no vacía.
	public int tope(); // La pila debe estar inicializada y no vacía.
	public boolean pilaVacia(); // La pila debe estar inicializada.
}
