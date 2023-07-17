package Uso;

import imple.*;
import tda.*;

public class MetodosExternos_Modelo4 {
	
	public class Nodo{
		int info;
		Nodo sig;
	}
	
	public static ConjuntoTDA complementoVecindario(GrafoTDA G, ConjuntoTDA Vertices) {
		
		
		
	}

/*
	public static void Mezcla(ColaTDA inicio1, ColaTDA inicio2) {

		ConjuntoTDA ConjuntoAuxiliar = new Conjunto();
		ConjuntoAuxiliar.inicializarConjunto();
		ColaPrioridadTDA CCPAux = new ColaPrioridad();
		CCPAux.inicializarCola();

		while (!inicio1.colaVacia()) {
			ConjuntoAuxiliar.agregar(inicio1.primero());
			inicio1.desacolar();
		}

		while (!inicio2.colaVacia()) {
			ConjuntoAuxiliar.agregar(inicio2.primero());
			inicio2.desacolar();
		}

		while (!ConjuntoAuxiliar.conjuntoVacio()) {
			int valor = ConjuntoAuxiliar.elegir();
			CCPAux.acolarPrioridad(valor, valor);
			ConjuntoAuxiliar.sacar(valor);
		}

		while (!CCPAux.colaVacia()) {
			System.out.print(CCPAux.primero() + "-");
			CCPAux.desacolar();
		}
	}
*/
	
	/*
	public static Nodo Mezcla(Nodo inicio1, Nodo inicio2) {

		ConjuntoTDA ConjuntoAuxiliar = new Conjunto();
		ConjuntoAuxiliar.inicializarConjunto();
		ColaPrioridadTDA CCPAux = new ColaPrioridad();
		CCPAux.inicializarCola();
		Nodo melange = new Nodo();

		while (inicio1 != null) {
			ConjuntoAuxiliar.agregar(inicio1.info);
			inicio1 = inicio1.sig;
			}

		while (inicio2 != null) {
			ConjuntoAuxiliar.agregar(inicio2.info);
			inicio2 = inicio2.sig;
		}

		while (!ConjuntoAuxiliar.conjuntoVacio()) {
			int valor = ConjuntoAuxiliar.elegir();
			CCPAux.acolarPrioridad(valor, valor);
			ConjuntoAuxiliar.sacar(valor);
		}

		while (!CCPAux.colaVacia()) {
			Nodo aux = new Nodo();
			aux.info = CCPAux.primero();
			aux.sig = melange;
			melange = aux;
			CCPAux.desacolar();
		}
	}
*/
	
	public static void main(String[] args) {

		ColaTDA inicio1 = new Cola();
		ColaTDA inicio2 = new Cola();
		inicio1.inicializarCola();
		inicio2.inicializarCola();

		inicio1.acolar(1);
		inicio1.acolar(3);
		inicio1.acolar(5);
		inicio1.acolar(7);
		inicio2.acolar(2);
		inicio2.acolar(4);
		inicio2.acolar(5);
		inicio2.acolar(6);

		// Mezcla(inicio1, inicio2);

	}
}
