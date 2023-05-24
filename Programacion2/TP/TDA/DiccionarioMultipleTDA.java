package TDA;

public interface DiccionarioMultipleTDA {
  void inicializarDiccionario();
  void agregar(int clave, int valor); 		// Diccionario inicializado
  void eliminar(int clave); 				// Diccionrio inicializado
  void eliminarValor(int clave, int valor); // Diccionario inicializado 
  ConjuntoTDA recuperar(int clave); 		// Diccionario inicializado y clave existente
  ConjuntoTDA claves(); 					// Diccionario inicializado y no vacio
}
