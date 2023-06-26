package TDA;

public interface ConjuntoEspecialTDA {
	public class Respuesta {
		public boolean error;
		public int rta;
	}
	public void inicializarConjunto(); 
	public Respuesta agregar(int valor); // El conjunto debe estar inicializado
	public Respuesta sacar(int valor); // El conjunto debe estar inicializado
	public Respuesta elegir(); // El conjunto debe estar inicializado
	public boolean pertenece(int valor); // El conjunto debe estar inicializado
	public boolean conjuntoVacio(); // El conjunto debe estar inicializaddo
}
