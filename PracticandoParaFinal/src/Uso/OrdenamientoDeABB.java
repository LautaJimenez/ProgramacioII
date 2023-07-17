package Uso;

import imple.*;
import tda.*;

public class OrdenamientoDeABB {

	public static void preorder(ABBTDA arbol) {
		if (!arbol.arbolVacio()) {
			System.out.print(arbol.raiz() + "-");
			preorder(arbol.hijoIzq());
			preorder(arbol.hijoDer());
		}
	}

	public static void inorder(ABBTDA arbol) {
		if (!arbol.arbolVacio()) {
			inorder(arbol.hijoIzq());
			System.out.print(arbol.raiz() + "-");
			inorder(arbol.hijoDer());
		}
	}

	public static void postorder(ABBTDA arbol) {
		if (!arbol.arbolVacio()) {
			postorder(arbol.hijoIzq());
			postorder(arbol.hijoDer());
			System.out.print(arbol.raiz() + "-");
		}
	}


	public static void main(String[] args) {
		
		ABBTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregarElem(8);
		arbol.agregarElem(15);
		arbol.agregarElem(2);
		arbol.agregarElem(63);
		arbol.agregarElem(19);
		
		postorder(arbol);

	}

}
