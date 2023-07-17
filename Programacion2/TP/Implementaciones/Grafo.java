package Implementaciones;

import TDA.ConjuntoTDA;
import TDA.GrafoTDA;

public class Grafo implements GrafoTDA {
  static int n = 100;
  int[][] MAdy;
  int[] Vertices;
  int cantidadNodos;

  public void inicializarGrafo() {
    MAdy = new int[n][n];
    Vertices = new int[n];
    cantidadNodos = 0;
  }

  public void agregarVertice(int v) {
    Vertices[cantidadNodos] = v;
    for (int i = 0; i < cantidadNodos; i++) {
      MAdy[cantidadNodos][i] = 0;
      MAdy[i][cantidadNodos] = 0;
    }
    cantidadNodos++;
  }

  public void eliminarVertice(int v) {
    int i = vertice2indice(v);

    for (int k = 0; k < cantidadNodos; k++) {
      MAdy[i][k] = MAdy[cantidadNodos - 1][k];
    }
    for (int k = 0; k < cantidadNodos; k++) {
      MAdy[k][i] = MAdy[k][cantidadNodos - 1];
    }

    Vertices[i] = Vertices[cantidadNodos - 1];
    cantidadNodos--;
  }

  private int vertice2indice(int v) {
    int i = 0;

    while (i < cantidadNodos && Vertices[i] != v) {
      i++;
    }
    return i;
  }

  public ConjuntoTDA vertices() {
    ConjuntoTDA vert = new Conjunto();
    vert.inicializarConjunto();

    for (int i = 0; i < cantidadNodos; i++) {
      vert.agregar(Vertices[i]);
    }
    return vert;
  }

  public void agregarArista(int v1, int v2, int peso) {
    int indicev1 = vertice2indice(v1);
    int indicev2 = vertice2indice(v2);

    MAdy[indicev1][indicev2] = peso;
  }

  public void eliminarArista(int v1, int v2) {
    int indicev1 = vertice2indice(v1);
    int indicev2 = vertice2indice(v2);

    MAdy[indicev1][indicev2] = 0;
  }

  public boolean existeArista(int v1, int v2) {
    int indicev1 = vertice2indice(v1);
    int indicev2 = vertice2indice(v2);
    return MAdy[indicev1][indicev2] != 0;
  }

  public int pesoArista(int v1, int v2) {
    int indicev1 = vertice2indice(v1);
    int indicev2 = vertice2indice(v2);
    return MAdy[indicev1][indicev2];
  }
}
