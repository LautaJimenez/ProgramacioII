 package TDA;

public interface ConjuntoTDA {
  void inicializarConjunto();
  void agregar(int x); //conjunto inicializado
  void sacar(int x); //conjunto inicializado
  int elegir(); //conjunto inicializado y no vacío
  boolean Pertenece(int x); //conjunto inicializado
  boolean conjuntoVacio(); //conjunto inicializado
}
