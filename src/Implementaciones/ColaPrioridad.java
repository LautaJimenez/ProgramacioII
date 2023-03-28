package Implementaciones;

import TDA.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	private int[] elementos;
	private int[] prioridades;
	private int indice;
	
	public void inicializarCola() {
		indice = 0;
		elementos = new int[100];
		prioridades = new int[100];
	}

	public void acolarPrioridad(int numero, int prioridad) {
		
		int j = indice;
		
		for( ; j>0 && prioridades[j-1]>prioridad;j--) {
			elementos[j] = elementos[j-1];
			prioridades[j] = prioridades[j-1];
		}
		elementos[j] = numero;
		prioridades[j] = prioridad;
		indice++;
	}

	public void desacolar() {
		indice--;
	}

	public int primero() {
		return elementos[indice-1];
	}
	
	public int prioridad() {
		return prioridades[indice-1];
	}

	public boolean colaVacia() {
		return (indice==0);
	}
}
