package Implementaciones;

import TDA.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {

	class Nodo{
		int Numero;
		Nodo sig;
	}
	
	Nodo Conjunto;
	
	public void inicializarConjunto() {
		Conjunto = null;
	}

	
	public void agregar(int numero) {
		if(!this.pertenece(numero)) {
			Nodo Auxiliar = new Nodo();
			Auxiliar.Numero = numero;
			Auxiliar.sig = Conjunto;
			Conjunto = Auxiliar;
		}	
	}

	
	public int elegir() {	
		return(Conjunto.Numero);
	}

	
	public void sacar(int numero) {
		if(Conjunto!=null) {
			if(numero == Conjunto.Numero) {
				Conjunto = Conjunto.sig;
			}
			else {
				Nodo Auxiliar = Conjunto;
				while(Auxiliar.sig != null && Auxiliar.sig.Numero != numero) {
					Auxiliar = Auxiliar.sig;
				}
				if(Auxiliar != null) {
					Auxiliar.sig = Auxiliar.sig.sig;
				}
			}
		}
	}
	
	public boolean conjuntoVacio() {
		return (Conjunto == null);
	}

	
	public boolean pertenece(int numero) {
		Nodo aux = Conjunto;
		while(aux != null && aux.Numero != numero) {
			aux = aux.sig;
		}
		return(aux != null);
	}

	
	public boolean todosPertenecen(ConjuntoTDA X) {
		
		boolean todosPertenecen = true;
		ConjuntoTDA Auxiliar = X;
		Auxiliar.inicializarConjunto();
		
		while(!Auxiliar.conjuntoVacio()) {
			int valor = Auxiliar.elegir();
			if(!this.pertenece(valor)) {
				todosPertenecen = false;
			}
			Auxiliar.sacar(valor);
		}
		return todosPertenecen;
	}
	
	public void sacarTodos(ConjuntoTDA X) {
		ConjuntoTDA Auxiliar = X;
		Auxiliar.inicializarConjunto();
		
		while(!Auxiliar.conjuntoVacio()) {
			int valor = Auxiliar.elegir();
			if(this.pertenece(valor)) {
				this.sacar(valor);
			}
			Auxiliar.sacar(valor);
		}
	}
}
