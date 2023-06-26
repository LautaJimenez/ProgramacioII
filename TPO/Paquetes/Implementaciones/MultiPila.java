package Implementaciones;

import TDA.MultiPilaTDA;
import imple.Pila;
import tda.PilaTDA;

public class MultiPila implements MultiPilaTDA {

	class Nodo {
		int info;
		Nodo sig;
	}

	Nodo primero;

	/**
	 * Es un metodo que inicializa la MultiPila estableciendo el nodo en null.
	 */

	public void inicializarPila() {
		primero = null;
	}

	/**
	 * Es un metodo que apila un valor pasado por parametro a la MultiPila.
	 * Estrategia: Se realiza una copia de los elementos de la pila pasada por
	 * parametro a una pila auxiliar, asi se invierte el orden de los mismos. Luego,
	 * mientras la pila auxiliar no este vacia, se inicializa un nodo auxiliar, y se
	 * le agrega al mismo el tope de la pila, y el puntero de aux apunta al nodo
	 * primero. Luego, el nodo primero se convierte en aux.
	 * 
	 * Costo: Lineal.
	 * 
	 * @param valores es una pila.
	 */

	public void apilar(PilaTDA valores) {

		PilaTDA PilaAuxiliar = new Pila();
		while (!valores.pilaVacia()) {
			PilaAuxiliar.apilar(valores.tope());
			valores.desapilar();
		}

		while (!PilaAuxiliar.pilaVacia()) {
			Nodo Aux = new Nodo();
			Aux.info = PilaAuxiliar.tope();
			Aux.sig = primero;
			primero = Aux;
			valores.apilar(PilaAuxiliar.tope());
			PilaAuxiliar.desapilar();
		}
	}

	/**
	 * Es un metodo que desapila de la MultiPila una conjunto de valores de una pila
	 * pasada por parametro, que deben coincidir con el tope de la multipila.
	 * Estrategia: Se copia la pila pasada por parametro a una pila auxiliar, para
	 * invertir el orden y que coincida con la de la MultiPila al recorrerla. Se
	 * inicializa un nodo auxiliar con el valor del nodo primero (primer elemento),
	 * y un booleano que verifica si coincide el valor de la Pila Auxiliar con el
	 * tope de la multipila. Se recorre la Pila auxiliar, y mientras esta no este
	 * vacia, el nodo auxiliar no sea null y coincidan los elementos, se va
	 * desapilando de la pila auxiliar y trasladando el puntero auxiliar al
	 * siguiente. Si finalmente el booleano coincide es true y la pila auxiliar es
	 * vacia, es decir que se verificaron todos los elementos de ella, el nodo
	 * primero se iguala al auxiliar (se eliminan todos los elementos verificados).
	 * 
	 * Costo: Lineal
	 * 
	 * @param valores es una pila.
	 */

	public void desapilar(PilaTDA valores) {
		PilaTDA PilaAuxiliar = new Pila();
		while (!valores.pilaVacia()) {
			PilaAuxiliar.apilar(valores.tope());
			valores.desapilar();
		}
		Nodo Auxiliar = primero;
		boolean coincide = true;

		while (!PilaAuxiliar.pilaVacia() && Auxiliar != null && coincide) {
			if (PilaAuxiliar.tope() != Auxiliar.info) {
				coincide = false;
			} else {
				PilaAuxiliar.desapilar();
				Auxiliar = Auxiliar.sig;
			}
		}
		if (coincide && PilaAuxiliar.pilaVacia()) {
			primero = Auxiliar;
		}
	}

	/**
	 * Es un metodo que retorna una cantidad de elementos pasados por parametros que
	 * corresponden a los primeros elementos de la MultiPila. Estrategia: Se
	 * inicializa un nodo auxiliar en primero, y se recorre el mismo mientras no sea
	 * null y la cantidad pasada por parametro sea mayor que cero. Se va apilando a
	 * la pila de resultados los valores correspondientes al nodo auxiliar. Costo:
	 * Lineal
	 * 
	 * @param cantidad representa la cantidad de elementos a agregar a la pila de
	 *                 resultados.
	 * 
	 * @return resultado es la pila con los elementos tope de la MultiPila.
	 */

	public PilaTDA tope(int cantidad) {
		PilaTDA resultado = new Pila();
		Nodo Auxiliar = primero;
		while (Auxiliar != null && cantidad > 0) {
			resultado.apilar(Auxiliar.info);
			Auxiliar = Auxiliar.sig;
			cantidad--;
		}
		return resultado;
	}

	/**
	 * Es un metodo que retorna un booleano confirmando si la pila esta vacia o no,
	 * mediante la verificacion si el nodo primero es null.
	 */

	public boolean pilaVacia() {

		return primero == null;
	}

}
