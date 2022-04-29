package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private ArrayList<ObjetoArista> listaDeAristas;
	private ArrayList<Espia> espias;
	private int cantidadDeEspias;
	private HashMap<Espia, HashSet<Espia>> listaDeVecinos;

	public Grafo() {
		this.cantidadDeEspias = 0;
		this.listaDeAristas = new ArrayList<ObjetoArista>();
		this.espias = new ArrayList<Espia>();
		this.listaDeVecinos = new HashMap<Espia, HashSet<Espia>>();
	}

	public boolean agregarEspia(String nombre) {
		
		Espia espiaNuevo = new Espia(nombre);
		boolean agregado = false;
		
		chequearNombreDeEspiaValido(nombre);
		chequearEspiaExistenteEnGrafo(espiaNuevo);
		
		espias.add(espiaNuevo);
		agregado = true;

		return agregado;
	}

	private void chequearEspiaExistenteEnGrafo(Espia posibleEspia) {
		if (espias.contains(posibleEspia) ) {
			throw new IllegalArgumentException("¡Ese espía ya existe!");
		}
	}
	
	private void chequearNombreDeEspiaValido(String nombre) {
		if (nombre.length() == 0) {
			throw new IllegalArgumentException("¡Debe ingresar un nomre!");
		}
	}
	
	
	public boolean agregarRelacionEntreEspias(String espia1Nombre, String espia2Nombre, Integer peso) {

		boolean aristaAgregada = false;
		
		Espia espia1 = new Espia(espia1Nombre);
		Espia espia2 = new Espia(espia2Nombre);
		
		chequearRelacionesCirculares(espia1,espia2);

		ObjetoArista aristaNueva = new ObjetoArista(espia1, espia2, peso);

		if (!listaDeAristas.contains(aristaNueva)) {
			listaDeAristas.add(aristaNueva);
			agregarAListaDeVecinos(espia1, espia2);
			agregarAListaDeVecinos(espia2, espia1);
			aristaAgregada = true;
		}
		
		return aristaAgregada;
	}
	
	void chequearRelacionesCirculares(Espia espia1, Espia espia2) {
		if (espia1.equals(espia2)) {
			throw new IllegalArgumentException("Un espía no puede enviarse el mensaje a sí mismo.");
		}
	}
	

	private void agregarAListaDeVecinos(Espia espia1, Espia espia2) {
		if (!listaDeVecinos.containsKey(espia1)) {
			listaDeVecinos.put(espia1, new HashSet<Espia>());
			listaDeVecinos.get(espia1).add(espia2);
		} else {
			listaDeVecinos.get(espia1).add(espia2);
		}
	}

//	public void eliminarRelacionEntreEspias(Espia espia1, Espia espia2) {
//		RelacionEntreEspias aux = new RelacionEntreEspias();
//		for (RelacionEntreEspias r : relacionesEntreEspias) {
//			boolean existeRelacion = r.isEspiaEnRelacion(espia1) && r.isEspiaEnRelacion(espia2);
//			if (existeRelacion) {
//				aux.setEspia1(espia1).setEspia2(espia2).setPosibilidadDeIntercepcion(r.getPosibilidadDeIntercepcion());
//			}
//		}
//		eliminarVecinoAlNinja(aux.getEspia1(), aux.getEspia2());
//		eliminarVecinoAlNinja(aux.getEspia2(), aux.getEspia1());
//		relacionesEntreEspias.remove(aux);
//	}
//
//	private void eliminarVecinoAlNinja(Espia espia1, Espia espia2) {
//		if (!listaDeVecinos.containsKey(espia1)) {
//			return;
//		} else {
//			listaDeVecinos.get(espia1).remove(espia2);
//		}
//	}

	public boolean getExistenciaDeEspia(Espia espia1) {
		return listaDeVecinos.containsKey(espia1);
	}

	public ArrayList<ObjetoArista> getRelacionesEntreEspias() {
		ArrayList<ObjetoArista> temp = (ArrayList<ObjetoArista>) listaDeAristas.clone();
		return temp;
	}

	public ArrayList<Espia> getListaDeEspias() {
		return (ArrayList<Espia>) espias.clone();
	}

	public int getCantidadDeEspias() {
		return cantidadDeEspias;
	}

	public HashMap<Espia, HashSet<Espia>> getListaDeVecinos() {
		return (HashMap<Espia, HashSet<Espia>>) listaDeVecinos.clone();
	}

	public Espia getEspiaEspecifico(int i) {
		return espias.get(i);
	}

	public int indiceEspia(Espia e) {
		return espias.indexOf(e);
	}

	public Set<Espia> getVecinosDeUnEspia(Espia p) {

		Set<Espia> ret = new HashSet<Espia>();

		if (getExistenciaDeEspia(p))
			ret = listaDeVecinos.get(p);

		return ret;
	}

	public int getCantidadDeRelaciones() {
		return listaDeAristas.size();
	}
}