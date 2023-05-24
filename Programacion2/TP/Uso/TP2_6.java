package Uso;

import TDA.ConjuntoTDA;
import Implementaciones.Conjunto;

public class TP2_6 {

	static MetodosExternosConjuntos MetodosConjuntos = new MetodosExternosConjuntos();
	
  public static void main(String[] args) {
	  
	  ConjuntoTDA Conjunto1 = new Conjunto();
	  ConjuntoTDA Conjunto2 = new Conjunto();
	  Conjunto1.inicializarConjunto();
	  Conjunto2.inicializarConjunto();
	  
	  Conjunto1.agregar(1);
	  Conjunto1.agregar(2);
	  Conjunto1.agregar(3);
	  Conjunto1.agregar(4);
	  Conjunto1.agregar(5);
	  
	  Conjunto2.agregar(3);
	  Conjunto2.agregar(4);
	  Conjunto2.agregar(5);
	  Conjunto2.agregar(6);
	  Conjunto2.agregar(7);
	    
	  MetodosConjuntos.imprimirConjunto(MetodosConjuntos.interseccionDeConjuntos(Conjunto1, Conjunto2));
	  MetodosConjuntos.imprimirConjunto(MetodosConjuntos.unionDeConjuntos(Conjunto1, Conjunto2));
	  MetodosConjuntos.imprimirConjunto(MetodosConjuntos.diferenciaDeConjuntos(Conjunto2, Conjunto1));
	  MetodosConjuntos.imprimirConjunto(MetodosConjuntos.diferenciaDeConjuntos(Conjunto1, Conjunto2));
	  MetodosConjuntos.imprimirConjunto(MetodosConjuntos.diferenciaSimetricaEntreConjuntos(Conjunto1, Conjunto2));
  }
}

