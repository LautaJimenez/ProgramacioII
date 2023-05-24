package Implementaciones;

import TDA.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
  
	int cantidadElementos;
	int[] arr;
	
  public void inicializarConjunto() {
	  arr = new int[100];
	  cantidadElementos = 0;
	  
  } 

  public void agregar(int x) {
    if (!this.Pertenece(x)) {
      arr[cantidadElementos] = x;
      cantidadElementos++;
    }
  }

  public void sacar(int x) {
    int i = 0;

    while (i < cantidadElementos && arr[i] != x) {
      i++;
    }

    if (i != cantidadElementos) { //Lo encontré
      arr[i] = arr[cantidadElementos - 1]; // Para sacar el elemento, se sobreescribe con el ultimo elemento del arreglo, y después se pisa el ultimo elemento asi no queda repetido.
      cantidadElementos--;
    }
  } 

  public int elegir() {
    return arr[cantidadElementos-1];
  }

  public boolean Pertenece(int x) {
	  int i = 0;
	  while(i < cantidadElementos && arr[i] != x) {
		  i++;
	  }
	  return (i < cantidadElementos);
  }

  public boolean conjuntoVacio() {
    return (cantidadElementos == 0);
  }
}
