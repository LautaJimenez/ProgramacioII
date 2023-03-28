package Implementaciones;

import TDA.ColaTDA;

public class Cola implements ColaTDA {
	
	private int indice;
	private int[] arr;

	public void inicializarCola() {
		arr = new int[100];
		indice = 0;
	}
	
	public void acolar(int numero) {
		for (int i = indice;i>0;i--){
			arr[i] = arr[i-1];
		}
		arr[0] = numero;
		indice++;	
	}

	public void desacolar() {
		indice--;
	}

	public int primero() {
		return arr[indice-1];
	}

	public boolean colaVacia() {
		return (indice==0);
	}
}
