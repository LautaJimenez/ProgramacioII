package Uso;

import TDA.ABBTDA;
import Implementaciones.ABB;

public class TP4_3 {
	
	static MetodosExternosABB MetodosABB = new MetodosExternosABB(); 
	
	  public static void main(String[] args) {
		  
		  ABBTDA Arbol = new ABB();
		  Arbol.inicializarArbol();
		  Arbol.agregarElemento(10);
		  Arbol.agregarElemento(8);
		  Arbol.agregarElemento(3);
		  Arbol.agregarElemento(14);
		  Arbol.agregarElemento(17);
		  Arbol.agregarElemento(1);
		  Arbol.agregarElemento(12);
		  
		  //a) System.out.print(MetodosABB.estaEnArbol(Arbol, 10));
		  //b) System.out.print(MetodosABB.esHoja(Arbol, 17));
		  //c) System.out.print(MetodosABB.calcularProfundidad(Arbol, 8));
		  //d) System.out.print(MetodosABB.menorElemento(Arbol));
		  //e) System.out.print(MetodosABB.cantidadElementos(Arbol));
		  //f) System.out.print(MetodosABB.sumaElementos(Arbol));
		  //g) System.out.print(MetodosABB.cantidadHojas(Arbol));
		  //l)ii) MetodosABB.preorder(Arbol);
		  
		  
	  }
	
}

