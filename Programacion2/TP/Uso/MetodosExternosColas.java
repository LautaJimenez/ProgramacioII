package Uso;

import Implementaciones.Cola;
import Implementaciones.Pila;
import TDA.ColaTDA;
import TDA.PilaTDA;

public class MetodosExternosColas {

  public void imprimirCola(ColaTDA origen) {
    ColaTDA auxiliar = new Cola();
    auxiliar.inicializarCola();

    boolean esPrimerElemento = true;

    while (!origen.colaVacia()) {
      if (esPrimerElemento) {
        System.out.print(origen.primero());
        esPrimerElemento = false;
      } else {
        System.out.print("-" + origen.primero());
      }
      auxiliar.acolar(origen.primero());
      origen.desacolar();
    }

    while (!auxiliar.colaVacia()) {
      origen.acolar(auxiliar.primero());
      auxiliar.desacolar();
    }
  }

  public void pasarCola(ColaTDA origen, ColaTDA C2) {
    while (!origen.colaVacia()) {
      C2.acolar(origen.primero());
      origen.desacolar();
    }
  }

  public void invertirCola1(ColaTDA origen) {
    PilaTDA auxiliar = new Pila();
    auxiliar.inicializarPila();

    while (!origen.colaVacia()) {
      auxiliar.apilar(origen.primero());
      origen.desacolar();
    }

    while (!auxiliar.pilaVacia()) {
      origen.acolar(auxiliar.tope());
      auxiliar.desapilar();
    }
  }

  public void coincideFinal(ColaTDA origen, ColaTDA C2) {
    PilaTDA pilaC1 = new Pila();
    ColaTDA auxiliarC1 = new Cola();
    pilaC1.inicializarPila();
    auxiliarC1.inicializarCola();

    while (!origen.colaVacia()) {
      auxiliarC1.acolar(origen.primero());
      origen.desacolar();
    }

    while (!auxiliarC1.colaVacia()) {
      origen.acolar(auxiliarC1.primero());
      pilaC1.apilar(auxiliarC1.primero());
      auxiliarC1.desacolar();
    }

    if (C2.primero() == pilaC1.tope()) {
      System.out.print("\n\nCoincide el final de la C1 con el inicio de la C2");
    } else {
      System.out.print("\n\nNO coincide el final de la C1 con el inicio de la C2");
    }
  }

  public void esCapicua(ColaTDA origen) {
    PilaTDA pilaAuxiliar = new Pila();
    ColaTDA C1Auxiliar = new Cola();
    pilaAuxiliar.inicializarPila();
    C1Auxiliar.inicializarCola();

    boolean capicua = true;

    while (!origen.colaVacia()) {
      pilaAuxiliar.apilar(origen.primero());
      C1Auxiliar.acolar(origen.primero());
      origen.desacolar();
    }

    while (!C1Auxiliar.colaVacia()) {
      origen.acolar(C1Auxiliar.primero());
      if (C1Auxiliar.primero() != pilaAuxiliar.tope()) {
        capicua = false;
      }
      C1Auxiliar.desacolar();
      pilaAuxiliar.desapilar();
    }

    if (capicua == true) {
      System.out.print("\n\nLa cola es capicua.");
    } else {
      System.out.print("\n\nLa cola NO es capicua.");
    }
  }

  public void sonInversas(ColaTDA origen, ColaTDA C2) {
    PilaTDA pilaAuxiliarC2 = new Pila();
    ColaTDA AuxiliarOrigen = new Cola();
    ColaTDA AuxiliarC2 = new Cola();
    int LargoOrigen = 0;
    int LargoC2 = 0;

    boolean sonInversas = true;

    while (!origen.colaVacia()) {
      AuxiliarOrigen.acolar(origen.primero());
      LargoOrigen++;
      origen.desacolar();
    }

    while (!C2.colaVacia()) {
      pilaAuxiliarC2.apilar(C2.primero());
      AuxiliarC2.acolar(C2.primero());
      LargoC2++;
      C2.desacolar();
    }

    while (!AuxiliarOrigen.colaVacia()) {
      if (AuxiliarOrigen.primero() != pilaAuxiliarC2.tope() || LargoOrigen != LargoC2) {
        sonInversas = false;
      }

      origen.acolar(AuxiliarOrigen.primero());
      C2.acolar(AuxiliarC2.primero());
      AuxiliarOrigen.desacolar();
      AuxiliarC2.desacolar();
      pilaAuxiliarC2.desapilar();
    }

    if (sonInversas == true) {
      System.out.print("Las colas son inversas");
    } else {
      System.out.print("Las colas NO son inversas");
    }
  }
}
