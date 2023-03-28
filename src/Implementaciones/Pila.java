package Implementaciones;

import TDA.PilaTDA;

public class Pila implements PilaTDA {

	private int indice;
	private int arr[];	
	
	public void inicializarPila() {
		arr = new int[100];
		indice = 0;
	}

	public void apilar(int numero) {
		arr[indice] = numero;
		indice++;
	}

	
	public void desapilar() {
		indice--;
	}

	public int tope() {
		return arr[indice-1];
	}

	public boolean pilaVacia() {
		return (indice==0);
	}
}
