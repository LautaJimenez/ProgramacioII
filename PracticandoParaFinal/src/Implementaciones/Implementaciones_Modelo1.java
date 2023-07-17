package Implementaciones;

import TDA.TDA_Modelo1;

public class Implementaciones_Modelo1 implements TDA_Modelo1 {

	private int capacidad;
	private int cantidadElementos;
	private int arr[];

	public void inicializarPila(int x) {
		capacidad = x;
		cantidadElementos = 0;
		arr = new int[100]; // Capaz conviene reemplazarlo por la capacidad.
	}

	public void apilar(int x) {

		if (cantidadElementos < capacidad) {
			arr[cantidadElementos] = x;
			cantidadElementos++;
		}

		else {
			int i = 0;
			while (i < cantidadElementos - 1) {
				arr[i] = arr[i + 1];
			}
			arr[cantidadElementos - 1] = x;
		}
	}

	public void desapilar() {
		cantidadElementos--;
	}

	public boolean pilaVacia() {

		return (cantidadElementos == 0);
	}

	public boolean pilaLlena() {

		return (capacidad == cantidadElementos);
	}

	public int capacidad() {

		return capacidad;
	}

	public int tope() {

		return arr[cantidadElementos - 1];
	}

}
