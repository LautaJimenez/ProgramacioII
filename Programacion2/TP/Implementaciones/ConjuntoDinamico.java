package Implementaciones;

import TDA.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {

	class Nodo{
		int valor;
		Nodo sig;
	}
	
	Nodo Conjunto;
  
  public void inicializarConjunto() {
	  Conjunto = null;
  } 

  public void agregar(int x) {
	  if(!this.Pertenece(x)) {
		  Nodo Aux = new Nodo();
		  Aux.valor = x;
		  Aux.sig = Conjunto;
		  Conjunto = Aux;
	  }
  } 

  public void sacar(int x) {
	  if(Conjunto != null) { // Si es el primer elemento de la lista
		  if(Conjunto.valor == x) {
			  Conjunto = Conjunto.sig;
		  }
	  
		  else {
			  Nodo Aux = Conjunto;
			  while(Aux.sig != null && Aux.sig.valor != x){
				  Aux = Aux.sig;
			  }
			  if(Aux.sig != null) {
				  Aux.sig = Aux.sig.sig;
			  }
		  } 
	  }
  }
  
  public int elegir() { 
    return Conjunto.valor;
  }

  public boolean Pertenece(int x) { 
    Nodo Aux = Conjunto;
    while((Aux != null) && (Aux.valor != x)) {
    	Aux = Aux.sig;
    }
    return(Aux != null);
  }
 
  public boolean conjuntoVacio() { 
    return (Conjunto==null);
  }
}

