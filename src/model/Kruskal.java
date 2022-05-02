package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Kruskal {

	private static Grafo grafo;
	private static ArrayList<ObjetoArista> listaDeRelaciones;
	private HashSet<String> espiasAgregados;

	public Kruskal(Grafo grafo) {
		this.grafo = grafo;
		listaDeRelaciones = grafo.getRelacionesEntreEspias();
		espiasAgregados = new HashSet<String>();
	}

	public Grafo arbolGeneradorMinimo() {

		Grafo arbolGenMin = new Grafo(grafo.getListaDeEspias());

		Collections.sort(listaDeRelaciones);// ordena segun el peso de las aristas

		int posicion = 0;
		int cantidadAristas = listaDeRelaciones.size();

		while (arbolGenMin.getCantidadDeRelaciones() < arbolGenMin.getCantidadDeEspias() - 1) {
			
			ObjetoArista relacionActual = listaDeRelaciones.get(posicion);

			if (BFS.esConexo(arbolGenMin)) {
				posicion++;

			} else {

				enviarMensajeSecreto(arbolGenMin, relacionActual);
				posicion++;
			}
		}
		return arbolGenMin;
	}

	private void enviarMensajeSecreto(Grafo arbolGenMin, ObjetoArista relacionActual) {

		arbolGenMin.agregarRelacionEntreEspias(relacionActual.getEspia1(), relacionActual.getEspia2(), relacionActual.getPosibilidadDeIntercepcion());

		anotarEspiasConMensajeEntregado(relacionActual.getEspia1(), relacionActual.getEspia2());
	}

	private void anotarEspiasConMensajeEntregado(String espia1, String espia2) {
		if (!espiasAgregados.contains(espia1))
			espiasAgregados.add(espia1);
		if (!espiasAgregados.contains(espia2))
			espiasAgregados.add(espia2);
	}
	
	public String toString() {
		return grafo.toString();
	}

}
