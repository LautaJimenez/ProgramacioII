package Uso;

import TDA.ColaPrioridadTDA;
import Implementaciones.Cola;
import Implementaciones.ColaPrioridad;
import TDA.ColaTDA;

public class EjercicioColaConPrioridad {
	
	// Acá van los métodos externos.
	 
	public static void pasarValoresyPrioridad(ColaPrioridadTDA Origen, ColaTDA Valores, ColaTDA Prioridades){
		
		//Vamos a escribir un método que nos permita pasar los valores de una cola con prioridad Origen a una
		//cola normal Valores, y las prioridades correspondientes a una cola normal Prioridades.
		
		while(!Origen.colaVacia()) {
			Valores.acolar(Origen.primero());
			Prioridades.acolar(Origen.prioridad());
			Origen.desacolar();
		}
	}
	
	
  public static void main(String[] args) {
	  
	  ColaPrioridadTDA ColaConPrioridad = new ColaPrioridad();
	  ColaTDA ColaValores = new Cola();
	  ColaTDA ColaPrioridades = new Cola();
	  
	  ColaConPrioridad.inicializarCola();
	  ColaValores.inicializarCola();
	  ColaPrioridades.inicializarCola();
	  
	  ColaConPrioridad.acolarPrioridad(1,3);
	  ColaConPrioridad.acolarPrioridad(2,1);
	  ColaConPrioridad.acolarPrioridad(3,7);
	  
	  pasarValoresyPrioridad(ColaConPrioridad,ColaValores,ColaPrioridades);
	  
	  while(!ColaValores.colaVacia()){
		  System.out.println("Valor: " + ColaValores.primero() + " Prioridad: " + ColaPrioridades.primero());
		  ColaPrioridades.desacolar();
		  ColaValores.desacolar();
	  }
  }
}

