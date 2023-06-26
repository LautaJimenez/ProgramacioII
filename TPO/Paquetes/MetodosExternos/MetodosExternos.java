package MetodosExternos;

import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;
import imple.DiccionarioSimple;
import tda.DiccionarioSimpleTDA;
import tda.DiccionarioMultipleTDA;
import tda.ColaTDA;
import imple.Cola;

public class MetodosExternos {

	// Ejercicio 4)

	/**
	 * Es un método que retorna el porcentaje de numeros pares de una pila recibida
	 * por parametro. Estrategia: Para calcular el porcentaje, se debe de tener la
	 * cantidad de numeros pares, y tambien la cantidad de elementos totales de una
	 * pila. Se recorre la pila obtenida por parametro hasta que quede vacia,
	 * preguntando si el elemento tope de la pila es par. Si es par, se suma 1 a la
	 * cantidad de numeros pares. Y si es o no es par, se suma 1 a la cantidad de
	 * elementos totales. Luego de recorrer toda la pila, retornamos la division
	 * entre la cantidad de elementos pares sobre la cantidad total de elementos.
	 * 
	 * Costo: Constante.
	 * 
	 * @param pila
	 * @return un float que corresponde al promedio de numeros pares de una pila.
	 */

	public static float porcentajePares(PilaTDA pila) {

		float cantidadElementos = 0;
		float cantidadPares = 0;

		while (!pila.pilaVacia()) {
			if (pila.tope() % 2 == 0) {
				cantidadPares++;
			}
			cantidadElementos++;
			pila.desapilar();
		}
		return (cantidadPares / cantidadElementos);
	}

	// Ejercicio 5)

	/**
	 * Es un método que retorna un conjunto con todos los elementos repetidos de una
	 * pila recibida por parametro. Estrategia: Se recorre la pila hasta que queda
	 * vacía. Ya que se necesitan los elementos repetidos en una pila, primeramente
	 * se agregan a un conjuto auxiliar los elementos de la pila a medida que se va
	 * recorriendo la misma, y si el tope de la pila, ya se pertenece al conjunto
	 * auxiliar, es porque es un elemento repetido, y se agrega al conjunto de
	 * repetidos.
	 * 
	 * Costo: Polinomico
	 * 
	 * @param pila
	 * @return un conjunto con los elementos repetidos de una pila.
	 */

	public static ConjuntoTDA elementosRepetidos(PilaTDA pila) {

		ConjuntoTDA conjuntoConRepetidos = new Conjunto();
		conjuntoConRepetidos.inicializarConjunto();

		ConjuntoTDA conjuntoAuxiliar = new Conjunto();
		conjuntoAuxiliar.inicializarConjunto();

		while (!pila.pilaVacia()) {
			if (conjuntoAuxiliar.pertenece(pila.tope())) {
				conjuntoConRepetidos.agregar(pila.tope());
			} else {
				conjuntoAuxiliar.agregar(pila.tope());
			}
			pila.desapilar();
		}
		return conjuntoConRepetidos;
	}

	// Ejercicio 6)

	/**
	 * Es un método que retorna un diccionario simple con las claves de los
	 * elementos de una pila recibida por parametro, y el valor de dicha clave es la
	 * cantidad de veces que se repite ese elemento en la pila. Estrategia: Se
	 * recorre la pila hasta que quede vacía, y si el tope de la pila ya se
	 * encuentra cargado en el diccionario, se suma 1 al valor de dicha clave en el
	 * diccionario. Si no se encuentra en el diccionario, se agrega al diccionario
	 * el tope como clave, y como valor un 1.
	 * 
	 * Costo: Polinomico
	 * 
	 * @param pila
	 * @return un diccionario simple que contine los elementos de una pila y cuantas
	 *         veces se repite el mismo dentro de ella.
	 */

	public static DiccionarioSimpleTDA diccionarioDePila(PilaTDA pila) {

		DiccionarioSimpleTDA diccionarioDeElementos = new DiccionarioSimple();
		diccionarioDeElementos.inicializarDiccionario();

		while (!pila.pilaVacia()) {
			if (diccionarioDeElementos.claves().pertenece(pila.tope())) {
				diccionarioDeElementos.agregar(pila.tope(), diccionarioDeElementos.recuperar(pila.tope()) + 1);
			} else {
				diccionarioDeElementos.agregar(pila.tope(), 1);
			}
			pila.desapilar();
		}

		return diccionarioDeElementos;

	}

	// Ejercicio 7)

	/**
	 * Es un método que retorna una cola con todos los valore de un diccionario
	 * multiple sin repetidos recibido por parametro. Estrategia: Se recorre el
	 * conjunto de claves del diccionario, hasta que el mismo quede vacio, y por
	 * cada clave, se recorre el conjunto de valores de esa clave hasta que quede
	 * vacio. Se utiliza un conjunto auxiliar para evitar repeticiones. Entonces,
	 * cada vez que estemos evaluando un valor, se realiza la comprobación de que el
	 * mismo no se encuentre en el conjunto auxiliar. Si no se encuentra en el
	 * conjunto auxiliar, se agrega a la cola, al conjunto auxiliar y luego se saca
	 * del conjunto de valores, sino unicamente se saca del conjunto de valores.
	 *
	 * Costo: Polinomico.
	 * 
	 * @param diccionario
	 * @return una cola con todos los valores sin repeticiones de un diccionario
	 *         multiple
	 */

	public static ColaTDA colaDeDiccionario(DiccionarioMultipleTDA diccionario) {

		ColaTDA cola = new Cola();
		cola.inicializarCola();

		ConjuntoTDA conjuntoAuxiliar = new Conjunto();
		conjuntoAuxiliar.inicializarConjunto();

		ConjuntoTDA conjuntoClaves = diccionario.claves();

		while (!conjuntoClaves.conjuntoVacio()) {
			int clave = conjuntoClaves.elegir();
			ConjuntoTDA conjuntoValores = diccionario.recuperar(clave);
			while (!conjuntoValores.conjuntoVacio()) {
				int valor = conjuntoValores.elegir();
				if (!conjuntoAuxiliar.pertenece(valor)) {
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

	/**
	 * Es un método en donde se obtiene la suma de todos los elementos pares de un
	 * arbol binario recibido por parametro. Estrategia: Se recorre el arbol hasta
	 * que quede vacio, y si la raiz del arbol es par, se retorna la raiz, y se
	 * recorre recursivamente ambos hijos, hasta llegar a el arbol vacio. Si la raiz
	 * no es par, se recorre recursivamente el arbol por ambos hijos, sin sumar la
	 * raiz.
	 * 
	 * Costo: Constante
	 * 
	 * @param arbol
	 * @return la suma de todos los elementos pares de un arbol binario.
	 */

	public static int sumaElementosPares(ABBTDA arbol) {
		if (!arbol.arbolVacio()) {

			if (arbol.raiz() % 2 == 0) {
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

	/**
	 * Es un método donde se cuentan la cantidad de hojas pares que contiene un
	 * arbol binario recibido por parametro. Estrategia: Se recorre el arbol hasta
	 * que quede vacio, y si la raiz es par, y sus 2 hijos son vacios, se retorna 1
	 * y se sigue recorriendo recursivamente el arbol a traves de ambos hijos. Si no
	 * se cumple la condicion, también se sigue recorriendo recursivamente el arbol
	 * a través de ambos hijos.
	 * 
	 * Costo: Constante.
	 * 
	 * @param arbol
	 * @return la cantidad de hojas pares de un arbol binario.
	 */

	public static int cantidadHojasPares(ABBTDA arbol) {

		if (!arbol.arbolVacio()) {

			if (arbol.raiz() % 2 == 0 && arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
				return 1 + cantidadHojasPares(arbol.hijoIzq()) + cantidadHojasPares(arbol.hijoDer());
			} else {
				return cantidadHojasPares(arbol.hijoIzq()) + cantidadHojasPares(arbol.hijoDer());
			}
		}

		else {
			return 0;
		}

	}

	// Ejercicio 10)

	/**
	 * Es un metodo que retorna un conjunto con los vertices puentes (que conectan)
	 * entre dos vertices en un grafo recibidos por parametro. Estrategia: Se
	 * recorre el conjunto de vertices del grafo hasta que el mismo esté vacio. Se
	 * utiliza el metodo interno existearista que retorna un booleano si existe una
	 * arista entre el vertice origen (primer parametro) y vertice destino (segundo
	 * parametro).Si existe arista entre el uno de los vertices recibidos por
	 * parametro, y el vertice del grafo, y tambien existe arista entre el otro
	 * vertice recibido por parametro y el vertice del grafo, se agrega al conjunto
	 * a retornar el vertice del grafo.
	 * 
	 * Costo: Polinomico.
	 * 
	 * @param grafo
	 * @param vertice1
	 * @param vertice2
	 * @return un conjunto con todos los vertices puente entre 2 vertices de un
	 *         grafo pasados por parametro.
	 */

	public static ConjuntoTDA verticesPuente(GrafoTDA grafo, int vertice1, int vertice2) {

		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();

		ConjuntoTDA conjuntoVertices = grafo.vertices();

		while (!conjuntoVertices.conjuntoVacio()) {
			int vertice = conjuntoVertices.elegir();
			if ((grafo.existeArista(vertice1, vertice) && grafo.existeArista(vertice, vertice2))
					|| (grafo.existeArista(vertice2, vertice) && grafo.existeArista(vertice, vertice1))) {
				conjunto.agregar(vertice);
			}
			conjuntoVertices.sacar(vertice);
		}

		return conjunto;
	}

	// Ejercicio 11)

	/**
	 * Es un metodo calcula el grado de un vertice que se encuentra en un grafo.
	 * Ambos pasados por parametro. Estrategia: El grado de un vertice son todas las
	 * aristas salientes menos todas las aristas entrantes de un vertice. Para
	 * calcular el grado, se realizan dos contadores, tanto para la cantidad de
	 * aristas entrantes, como para la cantidad de aristas salientes. Se recorre el
	 * conjunto de vertices de el grafo, y si existe arista entre el vertice pasado
	 * por parametro con el vertice del grafo, dependiendo del orden de los
	 * parametros (vertice origen (primer parametro) y vertice destino (segundo
	 * parametro)), se incrementa el contador de aristas entrantes o salientes.
	 * 
	 * 
	 * Costo: Polinomico
	 * 
	 * @param grafo
	 * @param vertice
	 * @return
	 */

	public static int gradoVertice(GrafoTDA grafo, int vertice) {

		ConjuntoTDA conjuntoVertices = grafo.vertices();
		int cantidadSalientes = 0;
		int cantidadEntrantes = 0;

		while (!conjuntoVertices.conjuntoVacio()) {

			int vert = conjuntoVertices.elegir();

			if (grafo.existeArista(vertice, vert)) {
				cantidadSalientes++;
			}

			if (grafo.existeArista(vert, vertice)) {
				cantidadEntrantes++;
			}

			conjuntoVertices.sacar(vert);
		}
		return (cantidadSalientes - cantidadEntrantes);
	}

	public static void main(String[] args) {

	}
}
