package Implementaciones;

import TDA.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import tda.ColaPrioridadTDA;
import imple.ColaPrioridad;
import imple.Conjunto;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	private ColaPrioridadTDA CCP;

	/**
	 * Es un método que no retorna nada ni obtiene nada por parametro. Tampoco tiene
	 * precondiciones ni postcondiciones. Inicializa la cola con prioridad
	 * utilizando el metodo inicializarCola. Costo: Constante.
	 */

	public void inicializarDiccionario() {
		CCP = new ColaPrioridad();
		CCP.inicializarCola();
	}

	/**
	 * Es un método que agrega a la cola con prioridad una clave y valor pasadas por
	 * parametro (la clave se agrega como primero, y el valor como prioridad). Se
	 * realiza utilizando el metodo de acolarPrioridad.
	 * 
	 * Costo: Lineal
	 * 
	 * @param clave es la clave a agregar del diccionario simple
	 * @param valor es el valor asociado a la clave.
	 */

	public void agregar(int clave, int valor) {
		CCP.acolarPrioridad(clave, valor);
	}

	/**
	 * Es un metodo que elimina un elemento de la cola con prioridad según la clave
	 * pasada por parametro (No retorna nada). Estrategia: Se utiliza una cola con
	 * prioridad auxiliar. Se recorre la cola con prioridad original hasta que este
	 * vacia, y se pregunta si la clave pasada por parametro es igual a el valor que
	 * estamos parados en la cola con prioriad, si es asi se agrega la clave y el
	 * valor (primero y prioridad) de la cola original a la cola auxiliar. Luego, la
	 * cola auxiliar la volvemos a copiar a la cola original.
	 * 
	 * Costo: Polinomico
	 * 
	 * @param clave es la clave que corresponde al elemento a eliminar
	 */

	public void eliminar(int clave) {
		ColaPrioridadTDA Auxiliar = new ColaPrioridad();
		Auxiliar.inicializarCola();
		while (!CCP.colaVacia()) {
			int c = CCP.primero();
			int v = CCP.prioridad();
			if (clave != c) {
				Auxiliar.acolarPrioridad(c, v);
			}
			CCP.desacolar();
		}

		while (!Auxiliar.colaVacia()) {
			CCP.acolarPrioridad(Auxiliar.primero(), Auxiliar.prioridad());
			Auxiliar.desacolar();
		}
	}

	/**
	 * Es un metodo que te retorna un entero con el valor asociado a una clave
	 * pasada por parametro. Estrategia: Se utiliza una cola con prioridad auxiliar.
	 * Se recorre la cola con prioridad original hasta que quede vacia. Si el
	 * primero de la cola con prioridad coincide con la clave pasada por parametro,
	 * se guarda en una variable resultado el valor. Luego se realiza la copia de la
	 * cola original en la auxilair y viceversa para no perderla.
	 *
	 * Costo: Polinomico
	 *
	 * @param clave es la clave asociada al valor a obtener.
	 */

	public int recuperar(int clave) {
		ColaPrioridadTDA Auxiliar = new ColaPrioridad();
		Auxiliar.inicializarCola();
		int resultado = 0;
		while (!CCP.colaVacia()) {
			int c = CCP.primero();
			int v = CCP.prioridad();
			if (clave == c) {
				resultado = v;
			}
			Auxiliar.acolarPrioridad(c, v);
			CCP.desacolar();
		}

		while (!Auxiliar.colaVacia()) {
			CCP.acolarPrioridad(Auxiliar.primero(), Auxiliar.prioridad());
			Auxiliar.desacolar();
		}
		return resultado;
	}

	/**
	 * Es un metodo que retorna el conjunto de claves de un diccionario (en este
	 * caso, cola con prioridad). Estrategia: Se recorre la cola con prioridad
	 * original, y se va agregando el primero en un conjunto a retornar. Tambien se
	 * va agregando a una cola con prioridad auxiliar. Por ultimo se realiza la
	 * copia de la cola auxiliar en la original asi no se pierde el contenido.
	 * 
	 * Costo: Polinomico
	 */

	public ConjuntoTDA claves() {
		ColaPrioridadTDA Auxiliar = new ColaPrioridad();
		Auxiliar.inicializarCola();
		ConjuntoTDA conjuntoResultado = new Conjunto();
		conjuntoResultado.inicializarConjunto();

		while (!CCP.colaVacia()) {
			conjuntoResultado.agregar(CCP.primero());
			Auxiliar.acolarPrioridad(CCP.primero(), CCP.prioridad());
			CCP.desacolar();
		}

		while (!Auxiliar.colaVacia()) {
			CCP.acolarPrioridad(Auxiliar.primero(), Auxiliar.prioridad());
			Auxiliar.desacolar();
		}

		return conjuntoResultado;
	}

}
