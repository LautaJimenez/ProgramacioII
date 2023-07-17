package Uso;
import tda.ConjuntoTDA;
import tda.ColaTDA;
import imple.Conjunto;
import imple.Cola;
import apis.GrafoTDA;
import impl.GrafoLA;

public class MetodosExternos_FinalAdelantado {

	/*1) Tenemos dos colas, A y B, y queremos determinar si contienen exactamente los
	mismos elementos, sin que nos importen ni el orden ni las posibles repeticiones.
	Esto se debe realizar a través de un método externo.*/
	
	
	public static boolean mismosElementosEnConjunto(ColaTDA A, ColaTDA B) {
		boolean coincide = true;
		ColaTDA AuxiliarA = new Cola();
		ColaTDA AuxiliarB = new Cola();
		ConjuntoTDA ConjuntoA = new Conjunto();
		ConjuntoTDA ConjuntoB = new Conjunto();
		ConjuntoTDA ConjuntoAuxiliar = new Conjunto();
		
		AuxiliarA.inicializarCola();
		AuxiliarB.inicializarCola();
		ConjuntoA.inicializarConjunto();
		ConjuntoB.inicializarConjunto();
		ConjuntoAuxiliar.inicializarConjunto();
		
		while(!A.colaVacia()) {
			ConjuntoA.agregar(A.primero());
			AuxiliarA.acolar(A.primero());
			A.desacolar();
		}
		
		while(!B.colaVacia()) {
			ConjuntoB.agregar(B.primero());
			AuxiliarB.acolar(B.primero());
			B.desacolar();
		}
		
		while(!ConjuntoA.conjuntoVacio()) {
			int valor = ConjuntoA.elegir();
			if(!ConjuntoB.pertenece(valor)) {
				coincide = false;
			}
			ConjuntoAuxiliar.agregar(valor);
			ConjuntoA.sacar(valor);
		}
		
		while(!ConjuntoB.conjuntoVacio()) {
			int valor = ConjuntoB.elegir();
			if(!ConjuntoAuxiliar.pertenece(valor)) {
				coincide = false;
			}
			ConjuntoB.sacar(valor);
		}
		
		while(!AuxiliarA.colaVacia()) {
			A.acolar(AuxiliarA.primero());
			AuxiliarA.desacolar();
		}
		
		while(!AuxiliarB.colaVacia()) {
			B.acolar(AuxiliarB.primero());
			AuxiliarB.desacolar();
		}
		
		return coincide;
	}
	
	/*
	 5) 
	 	Dado un grafo, recordemos que un vértice aislado es un vértice que no tiene aristas entrantes ni salientes.
		Se pide:
		a) Defina una estrategia para encontrar, dado un grafo G, el conjunto de
		vértices aislados. Explique los pasos que planea dar para resolverlo.
		b) Escriba un método en Java que devuelva el conjunto de vértices aislados de un
		grafo pasado como parámetro.
		c) Pruebe el método vértices aislados, dando como salida por pantalla los vértices
		aislados del conjunto resultado.
	 */
	
	// public static ConjuntoTDA verticesAislados(GrafoTDA Grafo) {
		
		// No lo pude hacer.. Intentar terminar.
		
		
	// }
	
	public static void main(String[] args) {
		
		ColaTDA A = new Cola();
		ColaTDA B = new Cola();
		
		A.inicializarCola();
		B.inicializarCola();
		
		A.acolar(1);
		A.acolar(2);
		A.acolar(2);
		A.acolar(1);
		A.acolar(3);
		A.acolar(1);
		
		B.acolar(2);
		B.acolar(1);
		
		System.out.print(mismosElementosEnConjunto(A,B));
		
	}

}