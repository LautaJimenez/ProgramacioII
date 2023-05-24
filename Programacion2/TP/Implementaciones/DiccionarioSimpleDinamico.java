package Implementaciones;

import TDA.ConjuntoTDA;
import TDA.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {

  public class Nodo {
    int clave;
    int valor;
    Nodo sig;
  }

  Nodo Origen;

  public void inicializarDiccionario() {
    Origen = null;
  }

  public void agregar(int clave, int valor) {
    Nodo NC = Clave2NodoClave(clave);
    if (NC == null) {
      NC = new Nodo();
      NC.sig = Origen;
      NC.clave = clave;
      Origen = NC;
    }
    NC.valor = valor;
  }

  public void eliminar(int clave) {
    if (Origen != null) {
      if (Origen.clave == clave) {
        Origen.sig = Origen.sig.sig;
      } else {
        Nodo Auxiliar = Origen;
        while (Auxiliar != null && Auxiliar.clave != clave) {
          Auxiliar = Auxiliar.sig;
        }
        if (Auxiliar.sig != null) {
          Auxiliar.sig = Auxiliar.sig.sig;
        }
      }
    }
  }

  public int recuperar(int clave) {
    Nodo n = Clave2NodoClave(clave);
    return n.valor;
  }

  public ConjuntoTDA claves() {
    ConjuntoTDA ConjuntoClaves = new Conjunto();
    ConjuntoClaves.inicializarConjunto();

    Nodo Auxiliar = Origen;

    while (Auxiliar != null) {
      ConjuntoClaves.agregar(Auxiliar.clave);
      Auxiliar = Auxiliar.sig;
    }
    return ConjuntoClaves;
  }

  private Nodo Clave2NodoClave(int clave) {
    Nodo Auxiliar = Origen;
    while (Auxiliar != null && Auxiliar.clave != clave) {
      Auxiliar = Auxiliar.sig;
    }

    return Auxiliar;
  }
}
