 package Implementaciones;

import TDA.ConjuntoTDA;
import TDA.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

  class Elemento {
    int clave;
    int valor;
  }

  Elemento[] elementos;
  int cantidadElementos;

  public void inicializarDiccionario() {
    cantidadElementos = 0;
    elementos = new Elemento[100];
  }

  public void agregar(int clave, int valor) {
    int Posicion = Clave2Indice(clave);
    if (Posicion == -1) { // Es = -1 si no existía la clave anteriormente.
      Posicion = cantidadElementos;
      elementos[Posicion] = new Elemento();
      elementos[Posicion].clave = clave;
      cantidadElementos++;
    }
    elementos[Posicion].valor = valor; // Se agrega el valor fuera del if, por si ya existía la clave.
  }

  public void eliminar(int clave) {
    int Posicion = Clave2Indice(clave);
    if (Posicion != -1) { // Con este if, se comprueba que exista la clave.
      elementos[Posicion] = elementos[cantidadElementos - 1];
      cantidadElementos--;
    }
  }

  public int recuperar(int clave) {
    int Posicion = Clave2Indice(clave);
    return elementos[Posicion].valor;
  }

  public ConjuntoTDA claves() {
    ConjuntoTDA ConjuntoClaves = new Conjunto();
    ConjuntoClaves.inicializarConjunto();

    int i = 0;
    while (i <= cantidadElementos - 1) {
      ConjuntoClaves.agregar(elementos[i].clave);
      i++;
    }
    return ConjuntoClaves;
  }

  private int Clave2Indice(int clave) { // Despues probar de recorriendolo de adelante para atras, no de atrás para adelante.
    int i = cantidadElementos - 1;
    while (i >= 0 && elementos[i].clave != clave) {
      i--;
    }
    return i;
  }
}
