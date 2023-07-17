package Uso;

import Implementaciones.ABB;
import TDA.ABBTDA;
import TDA.ConjuntoTDA;
import Implementaciones.Conjunto;

public class MetodosExternosABB {
	
	static MetodosExternosConjuntos MetodosConjuntos = new MetodosExternosConjuntos();
	
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
	
	public int altura(ABBTDA arbol) {
		
		if(arbol.arbolVacio()) {
			return -1;
		}
		else if(altura(arbol.hijoDerecho()) > altura(arbol.hijoIzquierdo())) {
			return 1 + altura(arbol.hijoDerecho());
		}
		else {
			return 1 + altura(arbol.hijoIzquierdo());
		}
	}

	public boolean igualForma(ABBTDA arbol1, ABBTDA arbol2) {
		
		if(arbol1.arbolVacio() && arbol2.arbolVacio()) {
			return true;
		}
		
		else if((arbol1.arbolVacio() && !arbol2.arbolVacio()) || (!arbol1.arbolVacio()) && arbol2.arbolVacio()) {
			return false;
		}
		
		else if(arbol1.hijoDerecho().arbolVacio() == arbol2.hijoDerecho().arbolVacio() && arbol1.hijoIzquierdo().arbolVacio() && arbol2.hijoIzquierdo().arbolVacio()) {
			return (igualForma(arbol1.hijoDerecho(),arbol2.hijoDerecho()) && igualForma(arbol1.hijoIzquierdo(),arbol2.hijoIzquierdo()));
		}
		else {
			return false;
		}
	}
	
	public void preorder(ABBTDA arbol) {

		if(!arbol.arbolVacio()) {
			System.out.println(arbol.raiz());
			preorder(arbol.hijoIzquierdo());
			preorder(arbol.hijoDerecho());
		}
	}
	
	public void inorder(ABBTDA arbol) {
		
		if(!arbol.arbolVacio()) {
			inorder(arbol.hijoIzquierdo());
			System.out.println(arbol.raiz());
			inorder(arbol.hijoDerecho());
		}
	}
	
	public void postorder(ABBTDA arbol) {
		
		if(!arbol.arbolVacio()) {
			postorder(arbol.hijoIzquierdo());
			postorder(arbol.hijoDerecho());
			System.out.println(arbol.raiz());
		}
	}

	public ConjuntoTDA conjuntoDeElementos(ABBTDA arbol, int valor) {
		
		ConjuntoTDA Conjunto = new Conjunto();
		Conjunto.inicializarConjunto();
		
		if(!arbol.arbolVacio() && arbol.raiz() > valor) {
			Conjunto.agregar(arbol.raiz());
			MetodosConjuntos.unionDeConjuntos(Conjunto,conjuntoDeElementos(arbol.hijoIzquierdo(),valor));
			MetodosConjuntos.unionDeConjuntos(Conjunto,conjuntoDeElementos(arbol.hijoDerecho(),valor));	
			
		}
		
		while(!Conjunto.conjuntoVacio()) {
			int x = Conjunto.elegir();
			System.out.println(x);
			Conjunto.sacar(x);
		}
		
		return Conjunto;
		
		
	}

}

