package Implementaciones;

import TDA.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

	private int cantidadElementos;
	private int[] arr;

	Respuesta Rta;

	/**
	 * Es un metodo inicializa el conjunto creando un arreglo de 100 posiciones y
	 * estableciendo que la cantidad de elementos del conjunto es 0. No tiene
	 * parametros ni retorna nada.
	 */

	public void inicializarConjunto() {
		arr = new int[100];
		cantidadElementos = 0;
	}

	/**
	 * Es un metodo que agrega un valor pasado por parametro al conjunto y retorna
	 * un objeto con un valor booleano confirmando si se agrego o no. Estrategia:
	 * Medante el metodo pertenece, se consulta si el valor pasado por parametro
	 * pertenece al conjunto. Si no pertenece se agrega, se incrementa el contador
	 * de elementos del conjunto y se modifica el booleano del objeto a retornar.
	 * Costo: Lineal
	 * 
	 * @param valor corresponde al valor a agregar al conjunto
	 * @return Rta es el objeto con el booleano delimitando si se agrego o no el
	 *         valor en el conjunto.
	 * 
	 */

	public Respuesta agregar(int valor) {

		Rta.error = true;

		if (!this.pertenece(valor)) {
			arr[cantidadElementos] = valor;
			cantidadElementos++;
			Rta.error = false;
		}

		return Rta;
	}

	/**
	 * Es un metodo que elimina de el conjunto un valor pasado por parametro y
	 * retorna un objeto con un valor booleano confirmando si se quito o no del
	 * conjunto. Estrategia: Se recorre el conjunto y se verifica que el valor
	 * pasado por parametro no sea igual a un elemento del conjunto. En el caso de
	 * que sea igual, se procede a realizar un borrado logico.
	 * 
	 * Costo: Lineal
	 * 
	 * @param valor corresponde al valor a sacar del conjunto
	 * @return Rta corresponde a un objeto que contiene un booleano que confirma si
	 *         el valor se quito o no del conjunto
	 */

	public Respuesta sacar(int valor) {

		Rta.error = true;

		int i = 0;

		while (i < cantidadElementos && arr[i] != valor) {
			i++;
		}

		if (i != cantidadElementos) {
			arr[i] = arr[cantidadElementos - 1];
			cantidadElementos--;
			Rta.error = false;
		}

		return Rta;
	}

	/**
	 * Es un metodo que elige al "azar" un elemento del conjunto, y retorna un
	 * objeto con un booleano que confirma si se eligió un elemento y con el valor
	 * que se eligió. Estrategia: En el caso de que el conjunto no esté vacio,
	 * retorna un objeto con un booleano que certifique que no hubo error en el
	 * metodo y con el valor elegido. Costo: Constante.
	 * 
	 * @return Rta es un objeto con un booleano que confirma que se eligió un valor,
	 *         y con un entero que es el valor elegido
	 */

	public Respuesta elegir() {
		if (cantidadElementos == 0) {
			Rta.error = true;
		} else {
			Rta.error = false;
			Rta.rta = arr[cantidadElementos - 1];
		}
		return Rta;
	}

	/**
	 * Es un metodo que retorna un booleano verificando si un valor pasado por
	 * parametro pertenece o no a el conjunto. Estrategia: Se recorre el conjunto, y
	 * si el valor pasado por parametro es igual a un valor del conjunto, retorna un
	 * booleano que confirma que el valor existe en el conjunto. Costo: Lineal
	 * 
	 * @param valor es el valor que se verifica que existe o no en el conjunto.
	 * 
	 */

	public boolean pertenece(int valor) {
		int i = 0;
		while (i < cantidadElementos && arr[i] != valor) {
			i++;
		}
		return (i < cantidadElementos);
	}

	/**
	 * Es un metodo que retorna un booleano verifica que el conjunto está o no
	 * vacio. Estrategia: Se verifica que la cantidad de elementos del conjunto sea
	 * igual a 0.
	 * 
	 */
	public boolean conjuntoVacio() {
		return (cantidadElementos == 0);
	}

}
