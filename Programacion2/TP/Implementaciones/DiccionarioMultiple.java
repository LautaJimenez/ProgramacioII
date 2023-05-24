package Implementaciones;

import TDA.ConjuntoTDA;
import TDA.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

  class Elemento {
    int clave;
    int[] valores;
    int cantValores;
  }

  Elemento[] Elementos;
  int cantClaves;

  public void inicializarDiccionario() {
    Elementos = new Elemento[100];
    cantClaves = 0;
  }

  public void agregar(int clave, int valor) {
    int PosicionClave = clave2Indice(clave);
    if (PosicionClave == -1) { // Es = -1 si no existía la clave anteriormente.
      PosicionClave = cantClaves;
      Elementos[PosicionClave] = new Elemento();
      Elementos[PosicionClave].clave = clave;
      Elementos[PosicionClave].cantValores = 0;
      Elementos[PosicionClave].valores = new int[100];
      cantClaves++;
    }

    Elemento e = Elementos[PosicionClave];
    int PosicionValor = valor2Indice(e, valor);
    if (PosicionValor == -1) {
      e.valores[e.cantValores] = valor;
      e.cantValores++;
    }
  }

  private int valor2Indice(Elemento e, int valor) {
    int i = e.cantValores - 1;
    while (i >= 0 && e.valores[i] != valor) {
      i--;
    }
    return i;
  }

  private int clave2Indice(int clave) {
    int i = cantClaves - 1;
    while (i >= 0 && Elementos[i].clave != clave) {
      i--;
    }
    return i;
  }

  public void eliminar(int clave) {
    int PosicionClave = clave2Indice(clave);
    if (PosicionClave != -1) {
      Elementos[PosicionClave] = Elementos[cantClaves - 1];
      cantClaves--;
    }
  }

  public void eliminarValor(int clave, int valor) {
    int PosicionClave = clave2Indice(clave);

    if (PosicionClave != -1) {
      Elemento e = Elementos[PosicionClave];
      int PosicionValor = valor2Indice(e, valor);
      if (PosicionValor != -1) {
        e.valores[PosicionValor] = e.valores[e.cantValores - 1];
        e.cantValores--;
        if (e.cantValores == 0) {
          eliminar(clave);
        }
      }
    }
  }

  public ConjuntoTDA recuperar(int clave) {
    ConjuntoTDA ConjuntoValores = new Conjunto();
    ConjuntoValores.inicializarConjunto();

    int PosicionClave = clave2Indice(clave);
    if (PosicionClave != -1) {
      Elemento e = Elementos[PosicionClave];
      for (int i = 0; i < e.cantValores; i++) {
        ConjuntoValores.agregar(e.valores[i]);
      }
    }
    return ConjuntoValores;
  }

  public ConjuntoTDA claves() {
    ConjuntoTDA ConjuntoClaves = new Conjunto();
    ConjuntoClaves.inicializarConjunto();

    for (int i = 0; i < cantClaves; i++) {
      ConjuntoClaves.agregar(Elementos[i].clave);
    }
    return ConjuntoClaves;
  }
}
