package model;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	
	private int[] link;
	private Grafo grafo;
	private ArrayList<RelacionEntreEspias> listaDeRelaciones;
	
	public Kruskal(Grafo grafo) {
		this.grafo = grafo;
//		listaDeRelaciones = new ArrayList<RelacionEntreEspias>();
		listaDeRelaciones = grafo.getRelacionesEntreEspias();
	}
	
	//IMPLEMENTACION DE UNION-FIND
	private void initRoot() {
		link = new int[grafo.getCantidadDeEspias()];
		for (int j = 0; j < link.length; j++) {
			link[j] = j;
		}
	}
	
	//IMPLEMENTACION DE UNION-FIND
	//Determina si dos espías están en la misma componente conexa
	private int encontrarEspia(int i) {
		if (i== link[i]) {
			return i;
		}
		return link[i] = encontrarEspia(link[i]);
	}
	
	//IMPLEMENTACION DE UNION-FIND
	//Modifica la estructura de los árboles
	private void union(int i, int j) {
		int rootI=encontrarEspia(i);
		int rootJ=encontrarEspia(j);
		link[rootI]=rootJ;
	}
	
	public Grafo arbolGeneradorMinimo() {
		Grafo arbolGeneradorMinimo;
		
		listaDeRelaciones.sort(null);
		ArrayList<RelacionEntreEspias> aux = new ArrayList<>();
		initRoot();
		
		int connectedComponent = grafo.getCantidadDeEspias();
		int posicion = 0;
		
		while(connectedComponent!=1 && posicion < grafo.getCantidadDeRelaciones()) {
			RelacionEntreEspias current = listaDeRelaciones.get(posicion);
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
