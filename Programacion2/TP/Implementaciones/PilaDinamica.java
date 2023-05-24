package Implementaciones;

import TDA.PilaTDA;

public class PilaDinamica implements PilaTDA {
  
	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	
  public void inicializarPila() {
	  primero = null;
  } 

  public void apilar(int numero) {
	  Nodo aux = new Nodo();
	  aux.info = numero;
	  aux.sig = primero;
	  primero = aux;
  } 
  
  public void desapilar() {
	primero = primero.sig;  
  }
  
  public int tope() { 
     return primero.info;
  }

  public boolean pilaVacia() { 
    return(primero == null);
  }

@Override public void apilar2(int numero){// TODO Auto-generated method stub
}

}

