package Uso;

import Implementaciones.ColaPrioridad;
import TDA.ColaPrioridadTDA;

public class MetodosExternosColaConPrioridad {

  public void unificarColas(ColaPrioridadTDA C1, ColaPrioridadTDA C2) {
    
	  ColaPrioridadTDA ColaNueva = new ColaPrioridad();
    ColaNueva.inicializarCola();

    while (!C1.colaVacia()) {
      ColaNueva.acolarPrioridad(C1.primero(), C1.prioridad());
      C1.desacolar();
    }

    while (!C2.colaVacia()) {
      ColaNueva.acolarPrioridad(C2.primero(), C2.prioridad());
      C2.desacolar();
    }
    
	while(!ColaNueva.colaVacia()) {
		System.out.println("Primero: " + ColaNueva.primero() + " Prioridad: " + ColaNueva.prioridad());
		ColaNueva.desacolar();
	}
  }

  public void colasIdenticas(ColaPrioridadTDA C1, ColaPrioridadTDA C2) {
    boolean sonIdenticas = true;

    int LargoC1 = 0;
    int LargoC2 = 0;

    ColaPrioridadTDA C1Auxiliar = new ColaPrioridad();
    ColaPrioridadTDA C2Auxiliar = new ColaPrioridad();
    C1Auxiliar.inicializarCola();
    C2Auxiliar.inicializarCola();

    while (!C1.colaVacia()) {
      LargoC1++;
      C1Auxiliar.acolarPrioridad(C1.primero(), C1.prioridad());
      C1.desacolar();
    }

    while (!C2.colaVacia()) {
      LargoC2++;
      C2Auxiliar.acolarPrioridad(C2.primero(), C2.prioridad());
      C2.desacolar();
    }

    while (!C1Auxiliar.colaVacia() && LargoC1 == LargoC2) {
      if (
        C1Auxiliar.primero() != C2Auxiliar.primero() ||
        C1Auxiliar.prioridad() != C2Auxiliar.prioridad()
      ) {
        sonIdenticas = false;
      }

      C1.acolarPrioridad(C1Auxiliar.primero(), C1Auxiliar.prioridad());
      C2.acolarPrioridad(C2Auxiliar.primero(), C2Auxiliar.prioridad());
      C1Auxiliar.desacolar();
      C2Auxiliar.desacolar();
    }

    if (LargoC1 == LargoC2 && sonIdenticas == true) {
      System.out.println("Ambas colas con prioridad son identicas");
    } else {
      System.out.println("Ambas colas son diferentes entre si");
    }
  }
}
