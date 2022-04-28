package model;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	
	private Grafo grafo;
	private ArrayList<RelacionEntreEspias> listaDeRelaciones;
	
	public Kruskal(Grafo grafo) {
		this.grafo = grafo;
		listaDeRelaciones = grafo.getRelacionesEntreEspias();
	}
	
	public Grafo arbolGeneradorMinimo() {
		Grafo arbolGeneradorMinimo = new Grafo();
		
		Collections.sort(listaDeRelaciones);//ordena segun el peso de las aristas
		
		int connectedComponent = listaDeRelaciones.size();
		int posicion = 0;
		
		while(connectedComponent!=grafo.getCantidadDeEspias()-1) {
			RelacionEntreEspias relacionActual = listaDeRelaciones.get(posicion);
			
			if(!isRelacionFormaCiclo(arbolGeneradorMinimo.getRelacionesEntreEspias(), relacionActual)) {
				String espia1 = relacionActual.getEspia1().getNombre();
				Espia e1 = new Espia(espia1);
				String espia2 = relacionActual.getEspia2().getNombre();
				Espia e2 = new Espia(espia2);
				Integer peso = relacionActual.getPosibilidadDeIntercepcion();
				arbolGeneradorMinimo.agregarEspia(espia1);
				arbolGeneradorMinimo.agregarEspia(espia2);
				arbolGeneradorMinimo.agregarRelacionEntreEspias(e1, e2, peso);
			}
			 posicion++;
			 if(posicion==listaDeRelaciones.size()) {
				 posicion = 0;
			 }
		}
		
		return arbolGeneradorMinimo;
	}
	
	public boolean isRelacionFormaCiclo(ArrayList<RelacionEntreEspias> relaciones, RelacionEntreEspias r) {
		boolean isEspia1 = false;
		boolean isEspia2 = false;
		
		for (RelacionEntreEspias relacionEntreEspia : relaciones) {
			if(relacionEntreEspia.isEspiaEnRelacion(r.getEspia1())) isEspia1 = true;
			if(relacionEntreEspia.isEspiaEnRelacion(r.getEspia2())) isEspia2 = true;
		}
		
		return isEspia1 && isEspia2;
	}
}
