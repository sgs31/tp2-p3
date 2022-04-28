package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
	
	private Grafo grafo;
	private ArrayList<RelacionEntreEspias> listaDeRelaciones;//Esto es al pedo? porque entregamos un nuevo grafo en kruskal
	
	public Kruskal(Grafo grafo) {
		this.grafo = grafo;
		listaDeRelaciones = grafo.getRelacionesEntreEspias();
	}
	
	public Grafo arbolGeneradorMinimo() {
		Grafo arbolGeneradorMinimo;
		
		Collections.sort(listaDeRelaciones);
		
		int connectedComponent = grafo.getCantidadDeEspias();
		int posicion = 0;
		
		//PENSABA... MIENTRAS(LA CANTIDAD DE RELACIONES QUE TENGA EL ARBOLGENERADORMINIMO SEA MENOR A LA CANTIDAD
		//DE ESPIAS-1 [TODOS LOS GRAFOS GENERADORE MINIMO, TIENEN LA MISMA CANTIDAD DE RELACIONES QUE ESPIAS-1 
		while(connectedComponent!=1 && posicion < grafo.getCantidadDeRelaciones()) {
			RelacionEntreEspias current = listaDeRelaciones.get(posicion);
			//chequear primero si current hace que genere un ciclo
			//if(isFormaCiclo(current)) --hago algo--
			if (encontrarEspia(current.getEspia1().getId())!=encontrarEspia(current.getEspia2().getId())) {
				union(current.getEspia1().getId(), current.getEspia2().getId());
				aux.add(current);
				connectedComponent --;//?
			}
			 posicion++;//?
		}
		
		arbolGeneradorMinimo = new Grafo(aux, grafo.getCantidadDeEspias());
		
		return arbolGeneradorMinimo;
	}
}
