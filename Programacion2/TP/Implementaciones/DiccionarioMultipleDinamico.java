package Implementaciones;

import TDA.ConjuntoTDA;
import TDA.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {

	class NodoClave{
		int Clave;
		NodoValor Valores;
		NodoClave sigClave;
	}
	
	class NodoValor{
		int Valor;
		NodoValor sigValor;
	}
	
	NodoClave Origen;

  public void inicializarDiccionario() {
	  Origen = null;
  } 

  
  public void agregar(int clave, int valor) {
	  
	  NodoClave NC = clave2NodoClave(clave);
	  
	  if(NC == null) {
		  NC = new NodoClave();
		  NC.Clave = clave;
		  
	  }
  } 

  
  public void eliminar(int clave) {} 

  
  public void eliminarValor(int clave, int valor) {} 

  
  public ConjuntoTDA recuperar(int clave) { 
    return null;
  }

  
  public ConjuntoTDA claves() { 
    return null;
  }
  
  
  private NodoClave clave2NodoClave(int clave) {
	  NodoClave Auxiliar = Origen;
	  
	  while(Auxiliar != null && Auxiliar.Clave != clave) {
		  Auxiliar = Auxiliar.sigClave;
	  }
	  
	  return Auxiliar;
	  
  }
}

