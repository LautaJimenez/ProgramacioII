package Uso;
import TDA.PilaTDA;
import Implementaciones.Pila;

public class EjercicioPila{
	
	public static PilaTDA pasarPila(PilaTDA origen){// Con la palabra static, se puede utilizar el metodo libremente en toda la clase.
		
		PilaTDA destino = new Pila(); 				// PilaTDA: Nombre de la especificación (tipo de dato) / Pila: Nombre de la implementación. 
		  											// Declaro la pila destino (La pila origen ya fue dada como parametro).
		
		destino.inicializarPila(); 					// Inicializo la Pila destino.
		
		while(!origen.pilaVacia()) {
		destino.apilar(origen.tope());
		origen.desapilar();
		} 
		return destino;
	}
	
	public static int sumaDeValores(PilaTDA origen) {
		int Resultado = 0;
			
		while(!origen.pilaVacia()) {
			Resultado += origen.tope();
			origen.desapilar();
		}
		
		return Resultado;
	}
	
	public static void main(String[] args) {
		
		PilaTDA origen = new Pila();
		origen.inicializarPila();
		origen.apilar(1);
		origen.apilar(2);
		origen.apilar(3);
		origen.apilar(4);
		origen.apilar(98);
		
		System.out.println("La suma de los valores de la lista es: " + sumaDeValores(origen));
		
		origen.apilar(1);
		origen.apilar(2);
		origen.apilar(3);
		origen.apilar(4);
		origen.apilar(98);
		
		PilaTDA destino = pasarPila(origen);
		
		System.out.print("La lista es: ");
		
		while(!destino.pilaVacia()) {
			System.out.print(destino.tope()+"-");
			destino.desapilar();
		}
		

	}
}