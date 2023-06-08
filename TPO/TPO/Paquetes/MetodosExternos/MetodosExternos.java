package MetodosExternos;
import apis.PilaTDA;
import apis.ConjuntoTDA;
import impl.ConjuntoLD;
import impl.DicSimpleA;
import apis.DiccionarioSimpleTDA;
import apis.DiccionarioMultipleTDA;
import apis.ColaTDA;
import impl.ColaLD;
import apis.ABBTDA;
import apis.GrafoTDA;

public class MetodosExternos {

	// Ejercicio 4)
	
	public static float porcentajePares(PilaTDA pila) {
		
		float cantidadElementos = 0;
		float cantidadPares = 0;
		
		while(!pila.pilaVacia()) {
			if(pila.tope() % 2 == 0) {
				cantidadPares++;
			}
			cantidadElementos++;
			pila.desapilar();
		}
		return (cantidadPares/cantidadElementos);
	}
	
	// Ejercicio 5)
	
	public static ConjuntoTDA elementosRepetidos(PilaTDA pila) {
		
		ConjuntoTDA conjuntoConRepetidos = new ConjuntoLD();
		conjuntoConRepetidos.inicializarConjunto();
		
		ConjuntoTDA conjuntoAuxiliar = new ConjuntoLD();
		conjuntoAuxiliar.inicializarConjunto();
		
		while(!pila.pilaVacia()) {
			if(conjuntoAuxiliar.pertenece(pila.tope())) {
				conjuntoConRepetidos.agregar(pila.tope());
			}
			else {
				conjuntoAuxiliar.agregar(pila.tope());
			}
			pila.desapilar();
		}
		return conjuntoConRepetidos;
	}
	
	// Ejercicio 6)
	
	public static DiccionarioSimpleTDA diccionarioDePila(PilaTDA pila) {
		
		DiccionarioSimpleTDA diccionarioDeElementos = new DicSimpleA();
		diccionarioDeElementos.inicializarDiccionario();
		
		while(!pila.pilaVacia()) {
			if(diccionarioDeElementos.claves().pertenece(pila.tope())) {
				diccionarioDeElementos.agregar(pila.tope(), diccionarioDeElementos.recuperar(pila.tope())+1);
			}
			else {
				diccionarioDeElementos.agregar(pila.tope(), 1);
			}
			pila.desapilar();
		}
		
		return diccionarioDeElementos;
		
	}
	
	// Ejercicio 7)
	
	public static ColaTDA colaDeDiccionario(DiccionarioMultipleTDA diccionario) {
		
		ColaTDA cola = new ColaLD();
		cola.inicializarCola();
		
		ConjuntoTDA conjuntoAuxiliar = new ConjuntoLD();
		conjuntoAuxiliar.inicializarConjunto();
		
		ConjuntoTDA conjuntoClaves = diccionario.claves();
		
		while(!conjuntoClaves.conjuntoVacio()) {
			int clave = conjuntoClaves.elegir();
			ConjuntoTDA conjuntoValores = diccionario.recuperar(clave);
			while(!conjuntoValores.conjuntoVacio()) {
				int valor = conjuntoValores.elegir();
				if(!conjuntoAuxiliar.pertenece(valor)) {
					cola.acolar(valor);
					conjuntoAuxiliar.agregar(valor);
				}
				conjuntoValores.sacar(valor);
			}
			conjuntoClaves.sacar(clave);
		}
		return cola;
	}
	
	// Ejercicio 8)
	
	public static int sumaElementosPares(ABBTDA arbol) {
		if(!arbol.arbolVacio()) {
			
			if(arbol.raiz() % 2 == 0) {
				return arbol.raiz() + sumaElementosPares(arbol.hijoIzq()) + sumaElementosPares(arbol.hijoDer());
			}
			
			else {
				return sumaElementosPares(arbol.hijoIzq()) + sumaElementosPares(arbol.hijoDer());
			}
		}
		
		else {
			return 0;
		}
	}
	
	// Ejercicio 9)
	
	public static int cantidadHojasPares(ABBTDA arbol) {
		
		if(!arbol.arbolVacio()) {
			
			if(arbol.raiz() % 2 == 0 && arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
				return 1 + cantidadHojasPares(arbol.hijoIzq()) + cantidadHojasPares(arbol.hijoDer());
			}
			else {
				return cantidadHojasPares(arbol.hijoIzq()) + cantidadHojasPares(arbol.hijoDer());
			}
		}
		
		else {
			return 0;
		}
		
	}
	
	// Ejercicio 10)
	
	public static ConjuntoTDA verticesPuente(GrafoTDA grafo ,int vertice1, int vertice2) {
		
		ConjuntoTDA conjunto = new ConjuntoLD();
		conjunto.inicializarConjunto();
		
		ConjuntoTDA conjuntoVertices = grafo.vertices();
		
		while(!conjuntoVertices.conjuntoVacio()) {
			int vertice = conjuntoVertices.elegir();
			if((grafo.existeArista(vertice1, vertice) && grafo.existeArista(vertice, vertice2)) || (grafo.existeArista(vertice2, vertice) && grafo.existeArista(vertice, vertice1))){
				conjunto.agregar(vertice);
			}
			conjuntoVertices.sacar(vertice);
		}
		
		return conjunto;
	}
	
	// Ejercicio 11)
	
	public static int gradoVertice(GrafoTDA grafo, int vertice) {
		
		ConjuntoTDA conjuntoVertices = grafo.vertices();
		int cantidadSalientes = 0;
		int cantidadEntrantes = 0;
		
		
		while(!conjuntoVertices.conjuntoVacio()) {
			int vert = conjuntoVertices.elegir();
			
			if(grafo.existeArista(vertice,vert)){
				cantidadSalientes++;
			}
			if(grafo.existeArista(vert, vertice)) {
				cantidadEntrantes++;
			}
			
			conjuntoVertices.sacar(vert);
		}
		return (cantidadSalientes - cantidadEntrantes);
	}
	
	public static void main(String[] args) {

	}
	
	// Metodos adicionales
	
	public static void imprimirConjunto(ConjuntoTDA conjunto) {
		
		while(!conjunto.conjuntoVacio()) {
			int numero = conjunto.elegir();
			System.out.print(numero);
			conjunto.sacar(numero);
		}
	}

	public static void imprimirDiccionarioSimple(DiccionarioSimpleTDA diccionario) {
		ConjuntoTDA conjuntoDeClaves = diccionario.claves();
		
		while(!conjuntoDeClaves.conjuntoVacio()) {
			int clave = conjuntoDeClaves.elegir();
			System.out.println("Clave: "+ clave + " Valor: " +  diccionario.recuperar(clave));
			conjuntoDeClaves.sacar(clave);
		}
	}

	public static void imprimirCola(ColaTDA cola) {
		
		while(!cola.colaVacia()) {
			System.out.print(cola.primero() + " - ");
			cola.desacolar();
		}
	}

}
