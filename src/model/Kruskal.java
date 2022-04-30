package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Kruskal {

	private static Grafo grafo;
	private static ArrayList<ObjetoArista> listaDeRelaciones;
	private HashSet<Espia> espiasAgregados;

	public Kruskal(Grafo grafo) {
		this.grafo = grafo;
		listaDeRelaciones = grafo.getRelacionesEntreEspias();
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
		Espia espia1 = new Espia(relacionActual.getEspia1().getNombre());
		Espia espia2 = new Espia(relacionActual.getEspia2().getNombre());
		Integer peso = relacionActual.getPosibilidadDeIntercepcion();

		arbolGenMin.agregarRelacionEntreEspias(espia1.getNombre(), espia2.getNombre(), peso);

		anotarEspiasConMensajeEntregado(espia1, espia2);
	}

	private void anotarEspiasConMensajeEntregado(Espia espia1, Espia espia2) {
		if (!espiasAgregados.contains(espia1))
			espiasAgregados.add(espia1);
		if (!espiasAgregados.contains(espia2))
			espiasAgregados.add(espia2);
	}

}
