package Implementaciones;

import TDA.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	private class Elemento{ // Creo el objeto elemento.
		int valor;
		int prioridad;
	}
	
	Elemento[] arr; // Creo un arreglo del objeto Elemento.
	private int cantidadElementos;
	
	public void inicializarCola() {
		cantidadElementos = 0;
		arr = new Elemento[100];
	}

	public void acolarPrioridad(int numero, int prio) {
		
		int i = cantidadElementos;
		
		while(i>0 && prio <= arr[i-1].prioridad) { // Primero va el i>0, por el lazy evaluation.
			arr[i] = new Elemento();
			arr[i].valor = arr[i-1].valor;
			arr[i].prioridad = arr[i-1].prioridad;
			i--;
		}
		
		arr[i] = new Elemento(); // Instancio un nuevo objeto para pasar los valores recibidos por parametro, ya que llegamos al lugar donde van segun prioridad.
		arr[i].valor = numero;
		arr[i].prioridad = prio;
		cantidadElementos++;		
	}

	public void desacolar() {
		cantidadElementos--;
	}

	public int primero() {
		return arr[cantidadElementos-1].valor;
	}
	
	public int prioridad() {
		return arr[cantidadElementos-1].prioridad;
	}

	public boolean colaVacia() {
		return (cantidadElementos==0);
	}
}
