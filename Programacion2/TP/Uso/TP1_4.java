package Uso;

import TDA.ColaTDA;
import Implementaciones.Cola;

public class TP1_4 {
	
	static MetodosExternosColas metodosColas = new MetodosExternosColas();

  public static void main(String[] args) {
    ColaTDA Origen = new Cola();
    ColaTDA C2 = new Cola();
    
    Origen.inicializarCola();
    C2.inicializarCola();
    
    Origen.acolar(3);
    Origen.acolar(5);
    Origen.acolar(5);
    Origen.acolar(3);
    
    System.out.print("La cola original es: ");
    metodosColas.imprimirCola(Origen); 
    
    
    // a) metodosColas.pasarCola(Origen,C2);
    
    // System.out.print("\nLa cola destino es: ");
    // metodosColas.imprimirCola(C2);
  	

    // b) metodosColas.invertirCola1(Origen);
    
    // System.out.print("\nLa cola invertida es: ");
    // metodosColas.imprimirCola(Origen);
    
    // c) Hacer algoritmo de invertir una cola sin auxiliar de Pila.
    
    // C2.acolar(3);
    // C2.acolar(5);
    // C2.acolar(5);
    // C2.acolar(3);
    
    // d) metodosColas.coincideFinal(Origen, C2);
    
    // e) metodosColas.esCapicua(Origen);  
    
  }
}

