package Implementaciones;

import TDA.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {

	public class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad MayorPrioridad;
	
  
  public void inicializarCola() {
	  MayorPrioridad = null;
  } 
  
  public void acolarPrioridad(int numero, int prioridad) {
	  NodoPrioridad Nuevo = new NodoPrioridad();
	  Nuevo.info = numero;
	  Nuevo.prioridad = prioridad;
	  
	  if(MayorPrioridad == null || prioridad > MayorPrioridad.prioridad) { // Si la cola está vacía, o el elemento a ingresar es el de mayor prioridad
		  Nuevo.sig = MayorPrioridad;
		  MayorPrioridad = Nuevo;
	  }
	  
	  else{
		  NodoPrioridad Aux = MayorPrioridad;
		  
		  while(Aux.sig != null && Aux.sig.prioridad >= prioridad) {
			  Aux = Aux.sig;
		  }
		  Nuevo.sig = Aux.sig;
		  Aux.sig = Nuevo;
	  }
  } 

  public void desacolar() {
	  MayorPrioridad = MayorPrioridad.sig;
  } 
 
  public boolean colaVacia() { 
    return (MayorPrioridad == null);
  }
 
  public int prioridad() { 
    return (MayorPrioridad.prioridad);
  }
  
  public int primero() { 
    return (MayorPrioridad.info);
  }
  
  public int sumaPrioridades() {
	  return 0;
  }
}

