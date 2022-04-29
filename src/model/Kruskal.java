package model;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	
	private Grafo grafo;
	private ArrayList<ObjetoArista> listaDeRelaciones;
	
	public Kruskal(Grafo grafo) {
		this.grafo = grafo;
		listaDeRelaciones = grafo.getRelacionesEntreEspias();
	}
	
	public Grafo arbolGeneradorMinimo() {
		Grafo arbolGeneradorMinimo = new Grafo(grafo.getListaDeEspias());
		
		Collections.sort(listaDeRelaciones);//ordena segun el peso de las aristas
	
		int posicion = 0;
		int cantidadAristas = listaDeRelaciones.size();
		
		while(arbolGeneradorMinimo.getCantidadDeRelaciones() < arbolGeneradorMinimo.getCantidadDeEspias()-1) {

			ObjetoArista relacionActual = listaDeRelaciones.get(posicion);
		
			if(isAristaFormaCiclo(arbolGeneradorMinimo.getRelacionesEntreEspias(), relacionActual))  posicion++;
			else {
				String espia1 = relacionActual.getEspia1().getNombre();
				Espia e1 = new Espia(espia1);
				String espia2 = relacionActual.getEspia2().getNombre();
				Espia e2 = new Espia(espia2);
				Integer peso = relacionActual.getPosibilidadDeIntercepcion();
				arbolGeneradorMinimo.agregarRelacionEntreEspias(e1.getNombre(), e2.getNombre(), peso);
				posicion++;
			}
			if(posicion == (cantidadAristas-1)) {
				 posicion = 0;
			 }
			System.out.println(posicion);
		}
		
		return arbolGeneradorMinimo;
	}
	
	public static boolean isAristaFormaCiclo(ArrayList<ObjetoArista> relaciones, ObjetoArista r) {
		boolean isEspia1 = false;
		boolean isEspia2 = false;
			
		for (ObjetoArista relacionEntreEspia : relaciones) {
			if(relacionEntreEspia.isEspiaEnRelacion(r.getEspia1())) isEspia1 = true;
			if(relacionEntreEspia.isEspiaEnRelacion(r.getEspia2())) isEspia2 = true;
		}
		
		return isEspia1 && isEspia2;
	}
}
