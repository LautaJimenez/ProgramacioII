// Modelo de parcial 1, Ejercicio 2

package Implementaciones;

import TDA.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
	
	int cantidadElementos;
	int[] arr;
	
	public void inicializarConjunto() {
		arr = new int[100];
		cantidadElementos = 0;
	}

	public void agregar(int numero) {
		if(!this.pertenece(numero)) {
			arr[cantidadElementos] = numero;
			cantidadElementos++;
		}
	}
	
	public int elegir() {
		return arr[cantidadElementos-1];
	}
	
	public void sacar(int numero) {
		int i = 0;
		
		while(i<cantidadElementos && arr[i] != numero) {
			i++;
		}
		if(i != cantidadElementos) {
			arr[i] = arr[cantidadElementos-1];
			cantidadElementos--;
		}
	}

	public boolean conjuntoVacio() {	
		return(cantidadElementos == 0);
	}

	public boolean pertenece(int numero) {
		
		int i = 0;
		while(i<cantidadElementos && arr[i] != numero) {
			i++;
		}
		return(i<cantidadElementos);
	}

	public boolean todosPertenecen(ConjuntoTDA X) {
		
		boolean todosPertenecen = true;
		ConjuntoTDA Auxiliar = new ConjuntoEstatico();
		
		while(todosPertenecen == true && !X.conjuntoVacio()) { // Lineal
			int valor = X.elegir(); // Constante
			Auxiliar.agregar(valor); // Lineal
			
			if(!this.pertenece(valor)) { // Lineal
				todosPertenecen = false; // Constante
			}
			X.sacar(valor); // Lineal
		} // Polinomico
		
		while(!Auxiliar.conjuntoVacio()) { // Lineal
			int valor = Auxiliar.elegir(); // Constante
			X.agregar(valor); // Lineal
			Auxiliar.sacar(valor); // Lineal
		} // Polinomico
		
		return todosPertenecen;
	} // Polinomico

	public void sacarTodos(ConjuntoTDA X) {
		
		ConjuntoTDA Auxiliar = new ConjuntoEstatico();
		Auxiliar.inicializarConjunto();

		while(!X.conjuntoVacio()) {
			int valor = X.elegir();
			Auxiliar.agregar(valor);
			if(this.pertenece(valor)) {
				this.sacar(valor);
			}
			X.sacar(valor);
		}
		
		while(!Auxiliar.conjuntoVacio()) {
			int valor = Auxiliar.elegir();
			X.agregar(valor);
			Auxiliar.sacar(valor);
		}
	}
}