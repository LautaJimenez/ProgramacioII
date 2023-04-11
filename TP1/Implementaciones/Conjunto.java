package Implementaciones;

import TDA.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
  
	int indice;
	int[] arr;
	
  public void inicializarConjunto() {} // TODO Auto-generated method stub

  public void agregar(int x) {
    if (!this.Pertenece(x)) {
      arr[indice] = x;
      indice++;
    }
  }

  public void sacar(int x) {
    int i = 0;

    while (i < indice && arr[i] != x) {
      i++;
    }

    if (i != indice) { //Lo encontré
      arr[i] = arr[indice - 1];
      indice--;
    }
  } // TODO Auto-generated method stub

  public int elegir() {
    return 0;
  }

  public boolean Pertenece(int x) { 
    return false;
  }

  public boolean conjuntoVacio() {
    return false;
  }
}
