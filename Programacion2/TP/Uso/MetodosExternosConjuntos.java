package Uso;

import Implementaciones.ConjuntoDinamico;
import TDA.ConjuntoTDA;

public class MetodosExternosConjuntos {

  public ConjuntoTDA interseccionDeConjuntos(
    ConjuntoTDA Conjunto1,
    ConjuntoTDA Conjunto2
  ) {
    ConjuntoTDA NuevoConjuntoInterseccion = new ConjuntoDinamico();
    ConjuntoTDA Auxiliar = new ConjuntoDinamico();
    NuevoConjuntoInterseccion.inicializarConjunto();
    Auxiliar.inicializarConjunto();

    while (!Conjunto1.conjuntoVacio()) {
      int Valor = Conjunto1.elegir();
      if (Conjunto2.Pertenece(Valor)) {
        NuevoConjuntoInterseccion.agregar(Valor);
      }
      Conjunto1.sacar(Valor);
      Auxiliar.agregar(Valor);
    }

    pasarConjunto(Conjunto1, Auxiliar);

    return NuevoConjuntoInterseccion;
  }

  public ConjuntoTDA unionDeConjuntos(ConjuntoTDA Conjunto1, ConjuntoTDA Conjunto2) {
    ConjuntoTDA Union = new ConjuntoDinamico();
    ConjuntoTDA AuxConjunto1 = new ConjuntoDinamico();
    ConjuntoTDA AuxConjunto2 = new ConjuntoDinamico();
    Union.inicializarConjunto();
    AuxConjunto1.inicializarConjunto();
    AuxConjunto2.inicializarConjunto();

    while (!Conjunto1.conjuntoVacio()) {
      int Valor = Conjunto1.elegir();
      Union.agregar(Valor);
      Conjunto1.sacar(Valor);
      AuxConjunto1.agregar(Valor);
    }

    while (!Conjunto2.conjuntoVacio()) {
      int Valor = Conjunto2.elegir();
      Union.agregar(Valor);
      Conjunto2.sacar(Valor);
      AuxConjunto2.agregar(Valor);
    }

    pasarConjunto(Conjunto1, AuxConjunto1);
    pasarConjunto(Conjunto2, AuxConjunto2);

    return Union;
  }

  public ConjuntoTDA diferenciaDeConjuntos(ConjuntoTDA Conjunto1, ConjuntoTDA Conjunto2) {
    ConjuntoTDA NuevoConjuntoDiferencia = new ConjuntoDinamico();
    ConjuntoTDA AuxiliarC1 = new ConjuntoDinamico();
    ConjuntoTDA AuxiliarC2 = new ConjuntoDinamico();
    NuevoConjuntoDiferencia.inicializarConjunto();
    AuxiliarC1.inicializarConjunto();
    AuxiliarC2.inicializarConjunto();

    while (!Conjunto1.conjuntoVacio()) {
      int Valor = Conjunto1.elegir();
      if (!Conjunto2.Pertenece(Valor)) {
        NuevoConjuntoDiferencia.agregar(Valor);
      }
      Conjunto1.sacar(Valor);
      AuxiliarC1.agregar(Valor);
    }

    pasarConjunto(Conjunto1, AuxiliarC1);

    return NuevoConjuntoDiferencia;
  }

  public ConjuntoTDA diferenciaSimetricaEntreConjuntos(
    ConjuntoTDA Conjunto1,
    ConjuntoTDA Conjunto2
  ) {
    return unionDeConjuntos(
      diferenciaDeConjuntos(Conjunto1, Conjunto2),
      diferenciaDeConjuntos(Conjunto2, Conjunto1)
    );
  }

  public void imprimirConjunto(ConjuntoTDA Conjunto) {
    ConjuntoTDA Auxiliar = new ConjuntoDinamico();
    Auxiliar.inicializarConjunto();
    boolean esPrimerElemento = true;

    System.out.print("El conjunto es: {");
    while (!Conjunto.conjuntoVacio()) {
      int Valor = Conjunto.elegir();
      if (esPrimerElemento) {
        System.out.print(Valor);
        esPrimerElemento = false;
      } else {
        System.out.print(" " + Valor);
      }
      Conjunto.sacar(Valor);
      Auxiliar.agregar(Valor);
    }

    System.out.print("}\n");

    pasarConjunto(Conjunto, Auxiliar);
  }

  public void pasarConjunto(ConjuntoTDA Conjunto, ConjuntoTDA Auxiliar) {
    while (!Auxiliar.conjuntoVacio()) {
      int Valor = Auxiliar.elegir();
      Conjunto.agregar(Valor);
      Auxiliar.sacar(Valor);
    }
  }
}
