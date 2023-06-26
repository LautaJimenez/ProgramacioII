package TDA;
import tda.PilaTDA;

public interface MultiPilaTDA {
	public void inicializarPila(); // La pila debe estar inicializada.
	public void apilar(PilaTDA valores); // La pila debe estar inicializada. 
	public void desapilar(PilaTDA valores); // La pila debe estar inicializada y no vacía.
	public PilaTDA tope(int cantidad); // La pila debe estar inicializada y no vacía.
	public boolean pilaVacia(); // La pila debe estar inicializada.
	
}
