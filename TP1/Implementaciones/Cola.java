package Implementaciones;

import TDA.ColaTDA;

public class Cola implements ColaTDA {
	
	private int cantidadElementos;
	private int[] arr;

	public void inicializarCola() {
		arr = new int[100];
		cantidadElementos = 0;
	}
	
	public void acolar(int numero) {
		for (int i = cantidadElementos-1;i>=0;i--){
			arr[i+1] = arr[i];
		}
		arr[0] = numero;
		cantidadElementos++;	
	}
	
	public void acolar2(int numero) {
		
		// Falta terminar para hacer el ejercicio de costos.
		
	}

	public void desacolar() {
		cantidadElementos--;
	}

	public int primero() {
		return arr[cantidadElementos-1];
	}

	public boolean colaVacia() {
		return (cantidadElementos==0);
	}

}