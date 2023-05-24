package Implementaciones;
import TDA.PilaTDA;

public class Pila implements PilaTDA {

	private int cantidadElementos;
	private int arr[];
	
	public void inicializarPila() {
		arr = new int[100];
		cantidadElementos = 0;
	}

	public void apilar(int numero) {
		arr[cantidadElementos] = numero;
		cantidadElementos++;
	}
	
	public void apilar2(int numero) {
		for(int i = 0; i<cantidadElementos; i++) {
			arr[i+1] = arr[i];
		}
		arr[0] = numero;
		cantidadElementos++;
	}
	
	public void desapilar() {
		cantidadElementos--;
	}

	public int tope() {
		return arr[cantidadElementos-1];
	}

	public boolean pilaVacia() {
		return (cantidadElementos==0);
	}
}	
