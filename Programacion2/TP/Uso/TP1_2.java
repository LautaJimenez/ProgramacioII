package Uso;

import Implementaciones.Pila;
import TDA.PilaTDA;

public class TP1_2 {
  static MetodosExternosPilas metodosPilas = new MetodosExternosPilas();

  public static void main(String[] args) {
    
	PilaTDA origen = new Pila();
    PilaTDA destino = new Pila();
    
    origen.inicializarPila();
    destino.inicializarPila();
    
    origen.apilar(1);
    origen.apilar(2);
    origen.apilar(11);

    // System.out.println("Pila original: ");
    // metodosPilas.imprimirPila(origen);
    // a) metodosPilas.pasarPilaInversa(origen,destino);
    // b) metodosPilas.pasarPilaMismoOrden(origen,destino);

    // System.out.println("Pila destino: ");
    // metodosPilas.imprimirPila(destino);

    // c) metodosPilas.invertirPila(origen);

    // System.out.println("Pila invertida: ");
    // metodosPilas.imprimirPila(origen);

    // d) System.out.print("La pila tiene " + metodosPilas.contarElementos(origen) + " elementos.");
    // e) System.out.print("La suma de sus elementos es " + metodosPilas.sumarElementos(origen));
    // f) System.out.print("El promedio de sus elementos es " + metodosPilas.promedioElementos(origen));

  }
}
