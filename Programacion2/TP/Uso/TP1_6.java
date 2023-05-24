package Uso;

import TDA.ColaPrioridadTDA;
import Implementaciones.ColaPrioridad;

public class TP1_6 {

	static MetodosExternosColaConPrioridad metodosCCP = new MetodosExternosColaConPrioridad();
	
  public static void main(String[] args) {
    
	  ColaPrioridadTDA C1 = new ColaPrioridad();
	  ColaPrioridadTDA C2 = new ColaPrioridad();
	  
	  C1.inicializarCola();
	  C2.inicializarCola();
	  

	  C1.acolarPrioridad(1,2);
	  C1.acolarPrioridad(2,3);
	  C1.acolarPrioridad(3,4);
	  
	  C2.acolarPrioridad(1,3);
	  C2.acolarPrioridad(2,5);
	  C2.acolarPrioridad(6,3);
	  
	  // a) metodosCCP.unificarColas(C1,C2);
	  
	  // b) metodosCCP.colasIdenticas(C1,C2);
	  
  }
}

