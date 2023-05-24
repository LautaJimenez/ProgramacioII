package Uso;

import Implementaciones.ABB;
import TDA.ABBTDA;

public class MetodosExternosABB {
	
	public boolean estaEnArbol(ABBTDA arbol, int valor) {
		if(arbol.arbolVacio()) {
			return false;
		}
		else if(arbol.raiz() == valor) {
			return true;
		}
		else if(arbol.raiz() > valor) {
			System.out.print(arbol.raiz());
			return this.estaEnArbol(arbol.hijoIzquierdo(),valor);
		}
		else{
			System.out.print(arbol.raiz());
			return this.estaEnArbol(arbol.hijoDerecho(),valor);
		}
	}
	
	public boolean esHoja(ABBTDA arbol, int valor) {
		
		if(arbol.arbolVacio()) {
			return false;
		}
		else if(arbol.raiz() == valor && arbol.hijoDerecho().arbolVacio() && arbol.hijoIzquierdo().arbolVacio()) {
			return true;
		}
		else if(arbol.raiz() > valor) {
			return this.esHoja(arbol.hijoIzquierdo(), valor);
		}
		else {
			return this.esHoja(arbol.hijoDerecho(), valor);
		}
	}

	public int calcularProfundidad(ABBTDA arbol, int valor) {
		
		if(arbol.arbolVacio()) {
			return 0;
		}
		else if(arbol.raiz() == valor) {
			return 1;
		}
		else if(arbol.raiz() < valor) {
			return 1 + calcularProfundidad(arbol.hijoDerecho(),valor);
		}
		else {
			return 1 + calcularProfundidad(arbol.hijoIzquierdo(),valor);
		}
		
	}
	
	public int menorElemento(ABBTDA arbol) {
		if(arbol.hijoIzquierdo().arbolVacio()) {
			return arbol.raiz();
		}
		else {
			return menorElemento(arbol.hijoIzquierdo());
		}
	}
	
	public int cantidadElementos(ABBTDA arbol) {
		if(!arbol.arbolVacio()) {
			return 1 + cantidadElementos(arbol.hijoIzquierdo()) + cantidadElementos(arbol.hijoDerecho());
		}
		else {
			return 0;
		}
	}
	
	public int sumaElementos(ABBTDA arbol) {
		if(!arbol.arbolVacio()) {
			return arbol.raiz() + sumaElementos(arbol.hijoIzquierdo()) + sumaElementos(arbol.hijoDerecho());
		}
		else {
			return 0;
		}
	}

	public int cantidadHojas(ABBTDA arbol) {
		
		if(!arbol.arbolVacio()) {
			if(arbol.hijoDerecho().arbolVacio() && arbol.hijoIzquierdo().arbolVacio())	{
				return 1 + cantidadHojas(arbol.hijoIzquierdo()) + cantidadHojas(arbol.hijoDerecho());
			}
			else {
				return 0 + cantidadHojas(arbol.hijoIzquierdo()) + cantidadHojas(arbol.hijoDerecho());
			}
		}
		
		else {
			return 0;
		}
	}
	
	public void preorder(ABBTDA arbol) {
		if(!arbol.arbolVacio()) {
			System.out.println(arbol.raiz());
			preorder(arbol.hijoIzquierdo());
			preorder(arbol.hijoDerecho());
		}
	}
}

