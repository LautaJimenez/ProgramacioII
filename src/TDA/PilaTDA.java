package TDA;

public interface PilaTDA {
	
	// Es obligatorio poner los comentarios en las interfaces.
	// Hay que poner las precondiciones.
	
	public void inicializarPila(); // No hay precondicion.
	public void apilar(int numero); // La pila debe estar inicializada.
	public void desapilar(); // La pila debe estar inicializada y no vacía.
	public int tope(); // La pila debe estar inicializada y no vacía.
	public boolean pilaVacia(); // La pila debe estar inicializada.
}
