package Uso;
import TDA.ColaTDA;
import Implementaciones.Cola;

public class EjercicioCola {
	
	public static ColaTDA pasarCola(ColaTDA origen){
		
		ColaTDA destino = new Cola();
		destino.inicializarCola();
		
		while(!origen.colaVacia()) {
			destino.acolar(origen.primero());
			origen.desacolar();
		}
		return destino;
	}
	
	public static void main(String[] args) {
		
		ColaTDA origen = new Cola();
		origen.inicializarCola();
		
		origen.acolar(0);
		origen.acolar(1);
		origen.acolar(2);
		origen.acolar(3);
		
		ColaTDA destino = pasarCola(origen);
		
		System.out.print("La cola es: ");
		
		while(!destino.colaVacia()) {
			System.out.print(destino.primero() + "-");
			destino.desacolar();
		}
	}
}
