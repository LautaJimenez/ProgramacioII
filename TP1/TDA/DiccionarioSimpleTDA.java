package TDA;

public interface DiccionarioSimpleTDA {
  void inicializarDiccionario();
  void agregar(int clave, int valor); 	//El diccionario debe estar inicializado.
  void eliminar(int clave); 			//El diccionario debe estar inicializado y no vacío.
  void recuperar(int clave); 			//El diccionario debe estar inicializado y clave existente.
  ConjuntoTDA claves(); 				//El diccionario debe estar inciializado
}
