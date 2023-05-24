package Implementaciones;

import TDA.ABBTDA;

class NodoABB{
	int valor;
	ABBTDA hijoIzquierdo;
	ABBTDA hijoDerecho;
}

public class ABB implements ABBTDA {	

  NodoABB raiz;
	
  public void inicializarArbol() {
	  raiz = null;
  } 

  
  public void agregarElemento(int x) {
	  if(raiz == null) {
		  raiz = new NodoABB();
		  raiz.valor = x;
		  raiz.hijoDerecho = new ABB();
		  raiz.hijoDerecho.inicializarArbol();
		  raiz.hijoIzquierdo = new ABB();
		  raiz.hijoIzquierdo.inicializarArbol();
	  }
	  else if(x > raiz.valor) {
		  raiz.hijoDerecho.agregarElemento(x);
	  }
	  else if(x < raiz.valor) {
		  raiz.hijoIzquierdo.agregarElemento(x);
	  }
  } 

  
  public void eliminarElemento(int x) {
	  if(raiz != null) {
		  if(raiz.valor == x && raiz.hijoDerecho.arbolVacio() && raiz.hijoIzquierdo.arbolVacio()) {
			  raiz = null;
		  }
		  else if(raiz.valor == x && !raiz.hijoIzquierdo.arbolVacio()) {
			  raiz.valor = this.mayor(raiz.hijoIzquierdo);
			  raiz.hijoIzquierdo.eliminarElemento(raiz.valor);
		  }
		  else if(raiz.valor == x && raiz.hijoIzquierdo.arbolVacio()) {
			  raiz.valor = this.menor(raiz.hijoDerecho);
			  raiz.hijoDerecho.eliminarElemento(raiz.valor);
		  }
		  else if(raiz.valor < x) {
			  raiz.hijoDerecho.eliminarElemento(x);
		  }
		  else {
			  raiz.hijoIzquierdo.eliminarElemento(x);
		  }
	  }	  
  } 
  
  private int mayor(ABBTDA arbol) {
	  if(arbol.hijoDerecho().arbolVacio()) {
		  return arbol.raiz();
	  }
	  else {
		  return mayor(arbol.hijoDerecho());
	  }
  }
  
  private int menor(ABBTDA arbol) {
	  if(arbol.hijoIzquierdo().arbolVacio()) {
		  return arbol.raiz();
	  }
	  else {
		  return menor(arbol.hijoIzquierdo());
	  }
  }
  
  public int raiz() { 
    return (raiz.valor);
  }

  
  public ABBTDA hijoIzquierdo() { 
    return (raiz.hijoIzquierdo);
  }

  
  public ABBTDA hijoDerecho() { 
    return (raiz.hijoDerecho);
  }

  
  public boolean arbolVacio() { 
    return (raiz == null);
  }
}

