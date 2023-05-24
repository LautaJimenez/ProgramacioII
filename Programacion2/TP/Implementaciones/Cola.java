package Implementaciones;

import TDA.ColaTDA;

public class Cola implements ColaTDA {
	
	private int cantidadElementos;
	private int sumaValores;
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
		sumaValores += numero;
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
	
	public double PromedioGeneral() {
		
		return (double)sumaValores/cantidadElementos;
	}
	
	public ColaTDA ColaDePromedios() {
		ColaTDA Salida = new Cola(); // C
		ColaTDA PromediosMenores = new Cola(); // C
		ColaTDA PromediosIguales = new Cola(); // C
		ColaTDA PromediosMayores = new Cola(); // C
		ColaTDA Auxiliar = new Cola(); // C
		Salida.inicializarCola(); // C
		PromediosMenores.inicializarCola(); // C
		PromediosIguales.inicializarCola(); // C
		PromediosMayores.inicializarCola(); // C
		Auxiliar.inicializarCola(); // C
		
		double PromedioGeneral = this.PromedioGeneral(); // C
		
		while(!this.colaVacia()) { // C
			Auxiliar.acolar(this.primero()); // L
			if(this.primero() > PromedioGeneral) { // C
				PromediosMayores.acolar(this.primero()); // L 
			}
			if(this.primero() == PromedioGeneral) { // C
				PromediosIguales.acolar(this.primero()); // L
			}
			if(this.primero() < PromedioGeneral) { // C
				PromediosMenores.acolar(this.primero()); // L
			}
			this.desacolar(); // C
		} // Polinomico de grado 3

		PromediosMayores.acolar(0); // L
		PromediosIguales.acolar(0); // L
		
		while(!PromediosMayores.colaVacia()) {
			Salida.acolar(PromediosMayores.primero()); // L
			PromediosMayores.desacolar(); // C
		} // Polinomico de grado 2
		
		while(!PromediosIguales.colaVacia()) {
			Salida.acolar(PromediosIguales.primero());
			PromediosIguales.desacolar();
		} // Polinomico de grado 2
		
		while(!PromediosMenores.colaVacia()) {
			Salida.acolar(PromediosMenores.primero());
			PromediosMenores.desacolar();
		}
		
		while(!Auxiliar.colaVacia()) {
			this.acolar(Auxiliar.primero());
			Auxiliar.desacolar();
		} // Polinomico de grado 2
		
		return Salida;
	} // Polinomico grado 3
	
	public void imprimirCola() {
		ColaTDA Auxiliar = new Cola();
		Auxiliar.inicializarCola();
		
		boolean esPrimerElemento = true;
		
		while(!this.colaVacia()) {
			if(esPrimerElemento) {
				System.out.print(this.primero());
				esPrimerElemento = false;
			}
			else {
				System.out.print("-" + this.primero());
			}
			
			Auxiliar.acolar(this.primero());
			this.desacolar();
		}
		
		while(!Auxiliar.colaVacia()) {
			this.acolar(Auxiliar.primero());
			Auxiliar.desacolar();
		}
	}

}