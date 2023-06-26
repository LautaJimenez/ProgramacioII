package TDA;
import tda.ConjuntoTDA;

public interface DiccionarioSimpleTDA {
	  public void inicializarDiccionario();
	  public void agregar(int clave, int valor); 	//El diccionario debe estar inicializado.
	  public void eliminar(int clave); 			//El diccionario debe estar inicializado y no vacío.
	  public int recuperar(int clave); 			//El diccionario debe estar inicializado y clave existente.
	  ConjuntoTDA claves(); 				//El diccionario debe estar inciializado
}
