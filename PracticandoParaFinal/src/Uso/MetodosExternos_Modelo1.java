package Uso;

import impl.*;
import apis.*;
import tda.*;
import tda.ConjuntoTDA;
import tda.PilaTDA;
import imple.*;

public class MetodosExternos_Modelo1 {

	// Hecho con chatGPT
	
	public static boolean existeCamino(GrafoTDA Grafo, int v1, int v2) {

		ConjuntoTDA visitados = new Conjunto();
		visitados.inicializarConjunto();
		PilaTDA pila = new Pila();
		pila.inicializarPila();
		pila.apilar(v1);
		while (!pila.pilaVacia()) {
			int vertice = pila.tope();
			pila.desapilar();
			if (vertice == v2) {
				return true;
			}
			visitados.agregar(vertice);
			apis.ConjuntoTDA vertices = Grafo.vertices();
			while (!vertices.conjuntoVacio()) {
				int posibleAdyacente = vertices.elegir();
				if (Grafo.existeArista(vertice, posibleAdyacente) && !visitados.pertenece(posibleAdyacente)) {
					pila.apilar(posibleAdyacente);
				}
				vertices.sacar(posibleAdyacente);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GrafoTDA grafo = new GrafoLA();
		grafo.inicializarGrafo();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(2, 3, 1);
		System.out.println(existeCamino(grafo, 1, 3)); // true
		System.out.println(existeCamino(grafo, 1, 4)); // false
	}
}
