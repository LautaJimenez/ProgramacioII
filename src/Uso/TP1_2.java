package Uso;

import Implementaciones.Pila;
import TDA.PilaTDA;

public class TP1_2 {

	// a)
	
	public static PilaTDA pasarPilaInversa(PilaTDA origen){
		
		PilaTDA destino = new Pila();
		destino.inicializarPila();
		
		System.out.println("Pila original: ");
		
		while(!origen.pilaVacia()) {
			destino.apilar(origen.tope());
			System.out.println("|" + origen.tope() + "|");
			origen.desapilar();
		}
		return destino;
	}
	
	// b)
	
	public static PilaTDA pasarPilaMismoOrden(PilaTDA origen) {
		
		PilaTDA auxiliar = new Pila();
		PilaTDA destino = new Pila();
		auxiliar.inicializarPila();
		destino.inicializarPila();
		
		System.out.println("Pila original: ");
		
		while(!origen.pilaVacia()) {
			auxiliar.apilar(origen.tope());
			System.out.println("|" + origen.tope() + "|");
			origen.desapilar();
		}
		
		while(!auxiliar.pilaVacia()) {
			destino.apilar(auxiliar.tope());
			auxiliar.desapilar();
		}
		
		return destino;
	}
	
	// d)
	
	public static int contarElementos(PilaTDA origen) {
		int contador = 0;
		
		while(!origen.pilaVacia()) {
			contador++;
			origen.desapilar();
		}
		return contador;
	}
	
	// e)
	
	public static int sumarElementos(PilaTDA origen) {
		
		int suma = 0;
		
		while(!origen.pilaVacia()) {
			suma = suma + origen.tope();
			origen.desapilar();
		}
		return suma;
	}
	
	// f)
	
	public static float  promedioElementos(PilaTDA origen) {
		
		float contador = 0;
		float suma = 0;
		float promedio;
		
		while(!origen.pilaVacia()) {
			contador++;
			suma += origen.tope();
			origen.desapilar();
		}
		promedio = suma/contador;
		return promedio;
	}
	
	public static void main(String[] args) {
		
		PilaTDA origen = new Pila();
		origen.inicializarPila();
		origen.apilar(1);
		origen.apilar(2);
		origen.apilar(11);
		
		// a) //PilaTDA destino = pasarPilaInversa(origen);
		// b) //PilaTDA destino = pasarPilaMismoOrden(origen);
		
		/*System.out.println("Pila destino: ");
		
		while(!destino.pilaVacia()) {
			System.out.println("|" + destino.tope() + "|");
			destino.desapilar();
		}*/
		
		// d) //System.out.print("La pila tiene " + contarElementos(origen) + " elementos.");
		// e) //System.out.print("La suma de sus elementos es " + sumarElementos(origen));
		// f) //System.out.print("El promedio de sus elementos es " + promedioElementos(origen));

	}
}
