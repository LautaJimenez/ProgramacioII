package Uso;

//import impl.PilaLD;
//import apis.PilaTDA;
import tda.ColaTDA;
import imple.Cola;

public class MetodosExternos_Modelo2 {

	/*
	 * Se tiene una lista enlazada, posiblemente vacía, de elementos de tipo Nodo
	 * cuyo primer elemento es el nodo origen. Dada una lista de este tipo,
	 * construir un método SumaRec recursivo que nos dé la suma de todos los valores
	 * de la lista
	 *

	public int SumaRec(PilaTDA origen) {

		if (origen == null) {
			return 0;
		}

		else {
			return origen.tope() + SumaRec(origen.Sig);
		}

	}*/

	/*
	 * Se tiene una cola contagios. Se pide escribir un método de tipo entero MaxSeq
	 * que reciba la cola contagios como entrada y devuelva la longitud de la máxima
	 * secuencia creciente
	 */

	public static int MaxSeq(ColaTDA contagios) {
		int MaximaSecuencia = 0;
		int Contador = 1;

		int Previo = contagios.primero();
		
		while (!contagios.colaVacia()) {
			int Actual = contagios.primero();
			if (Actual > Previo) {
				Contador++;
			} else {
				if (Contador > MaximaSecuencia) {
					MaximaSecuencia = Contador;
				}
				Contador = 1;
			}
			Previo = Actual;
			contagios.desacolar();
		}

		return MaximaSecuencia;

	}

	public static void main(String[] args) {
		
		ColaTDA Cola = new Cola();
		Cola.inicializarCola();
		Cola.acolar(7);
		Cola.acolar(2);
		Cola.acolar(4);
		Cola.acolar(3);
		Cola.acolar(4);
		Cola.acolar(5);
		Cola.acolar(2);
		Cola.acolar(3);
		Cola.acolar(1);
		
		System.out.print(MaxSeq(Cola));
		
	}
}
