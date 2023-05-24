package Implementaciones;

import TDA.ColaTDA;

public class ColaDinamica implements ColaTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	Nodo ultimo;
	
  public void inicializarCola() {
	  primero = null;
	  ultimo = null;
  }
 
  public void acolar(int numero) {
	  
	  Nodo aux = new Nodo();
	  aux.info = numero;
	  aux.sig = null;
	  
	  if(ultimo != null) { // Si la cola no esta vacia
		  ultimo.sig = aux;
	  }
	  
	  ultimo = aux;
	  
	  if(primero == null) { // Si la cola estaba vacia
		  primero = ultimo;
	  }
  }

  public void desacolar() {
	  primero = primero.sig;
	  
	  if(primero == null) { // So la cola queda vacia
		  ultimo = null;
	  }
  }

  public boolean colaVacia() {
    return (ultimo == null);
  }

  public int primero() {
    return (primero.info);
  }

@Override public double PromedioGeneral(){// TODO Auto-generated method stub
return 0;}

@Override public ColaTDA ColaDePromedios(){// TODO Auto-generated method stub
return null;}

@Override public void imprimirCola(){// TODO Auto-generated method stub
}

}
