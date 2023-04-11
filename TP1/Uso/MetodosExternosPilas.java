package Uso;

import Implementaciones.Pila;
import TDA.PilaTDA;

public class MetodosExternosPilas {

  public PilaTDA pasarPilaInversa(PilaTDA origen, PilaTDA destino) {
    while (!origen.pilaVacia()) {
      destino.apilar(origen.tope());
      origen.desapilar();
    }
    return destino;
  }

  public PilaTDA pasarPilaMismoOrden(PilaTDA origen, PilaTDA destino) {
    PilaTDA auxiliar = new Pila();
    auxiliar.inicializarPila();

    while (!origen.pilaVacia()) {
      auxiliar.apilar(origen.tope());
      origen.desapilar();
    }

    while (!auxiliar.pilaVacia()) {
      destino.apilar(auxiliar.tope());
      auxiliar.desapilar();
    }

    return destino;
  }

  public PilaTDA invertirPila(PilaTDA origen) {
    PilaTDA auxiliar1 = new Pila();
    PilaTDA auxiliar2 = new Pila();
    auxiliar1.inicializarPila();
    auxiliar2.inicializarPila();

    while (!origen.pilaVacia()) {
      auxiliar1.apilar(origen.tope());
      origen.desapilar();
    }

    while (!auxiliar1.pilaVacia()) {
      auxiliar2.apilar(auxiliar1.tope());
      auxiliar1.desapilar();
    }

    while (!auxiliar2.pilaVacia()) {
      origen.apilar(auxiliar2.tope());
      auxiliar2.desapilar();
    }

    return origen;
  }

  public int contarElementos(PilaTDA origen) {
    int contador = 0;

    while (!origen.pilaVacia()) {
      contador++;
      origen.desapilar();
    }
    return contador;
  }

  public int sumarElementos(PilaTDA origen) {
    int suma = 0;

    while (!origen.pilaVacia()) {
      suma = suma + origen.tope();
      origen.desapilar();
    }
    return suma;
  }

  public float promedioElementos(PilaTDA origen) {
    float contador = 0;
    float suma = 0;
    float promedio;

    while (!origen.pilaVacia()) {
      contador++;
      suma += origen.tope();
      origen.desapilar();
    }
    promedio = suma / contador;
    return promedio;
  }

  public void imprimirPila(PilaTDA origen) {
    PilaTDA auxiliar = new Pila();
    auxiliar.inicializarPila();

    while (!origen.pilaVacia()) {
      System.out.println("|" + origen.tope() + "|");
      auxiliar.apilar(origen.tope());
      origen.desapilar();
    }

    while (!auxiliar.pilaVacia()) {
      origen.apilar(auxiliar.tope());
      auxiliar.desapilar();
    }
  }
}
