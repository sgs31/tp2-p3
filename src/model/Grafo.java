package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private ArrayList<ObjetoArista> listaDeAristas;
	private ArrayList<String> espias;
	private HashMap<String, HashSet<String>> listaDeVecinos;

	public Grafo() {
		this.listaDeAristas = new ArrayList<ObjetoArista>();
		this.espias = new ArrayList<String>();
		this.listaDeVecinos = new HashMap<String, HashSet<String>>();
	}
	
	public Grafo(ArrayList<String> espias) {
		this.listaDeAristas = new ArrayList<ObjetoArista>();
		this.espias = espias;
		this.listaDeVecinos = new HashMap<String, HashSet<String>>();	
	}

	public boolean agregarEspia(String nombre) {
		
		boolean agregado = false;
		
		chequearNombreDeEspiaValido(nombre);
		chequearEspiaExistenteEnGrafo(nombre);
		
		espias.add(nombre);
		agregado = true;

		return agregado;
	}

	private void chequearEspiaExistenteEnGrafo(String posibleEspia) {
		if (espias.contains(posibleEspia) ) {
			throw new IllegalArgumentException("¡Ese espía ya existe!");
		}
	}
	
	private void chequearNombreDeEspiaValido(String nombre) {
		if (nombre.length() == 0) {
			throw new IllegalArgumentException("¡Debe ingresar un nomre!");
		}
	}
	
	
	 boolean agregarRelacionEntreEspias(String espia1, String espia2, Integer peso) {
		 //Hacer funcion que chequee que la arista no sea negativa
		 //Chequear que los espias existen
		boolean aristaAgregada = false;
		
		if(!espias.contains(espia1) || !espias.contains(espia2)) return aristaAgregada;
		
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
	
	void chequearRelacionesCirculares(String espia1, String espia2) {
		if (espia1.equals(espia2)) {
			throw new IllegalArgumentException("Un espía no puede enviarse el mensaje a sí mismo.");
		}
	}
	

	private void agregarAListaDeVecinos(String espia1, String espia2) {
		if (!listaDeVecinos.containsKey(espia1)) {
			listaDeVecinos.put(espia1, new HashSet<String>());
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

	public boolean getExistenciaDeEspia(String espia1) {
		return listaDeVecinos.containsKey(espia1);
	}

	public ArrayList<ObjetoArista> getRelacionesEntreEspias() {
		ArrayList<ObjetoArista> temp = (ArrayList<ObjetoArista>) listaDeAristas.clone();
		return temp;
	}

	public ArrayList<String> getListaDeEspias() {
		return (ArrayList<String>) espias.clone();
	}

	public int getCantidadDeEspias() {
		return espias.size();
	}

	public HashMap<String, HashSet<String>> getListaDeVecinos() {
		return (HashMap<String, HashSet<String>>) listaDeVecinos.clone();
	}

	public String getEspia(int i) {
		return espias.get(i);
	}

	public int indiceEspia(String e) {
		return espias.indexOf(e);
	}

	public Set<String> getVecinosDeUnEspia(String p) {

		Set<String> ret = new HashSet<String>();

		if (getExistenciaDeEspia(p))
			ret = listaDeVecinos.get(p);

		return ret;
	}

	public int getCantidadDeRelaciones() {
		return listaDeAristas.size();
	}
	
	public void eliminarAristas() {
		this.listaDeAristas = new ArrayList<ObjetoArista>();
		this.listaDeVecinos = new HashMap<String, HashSet<String>>();
	}
	
	public String toString() {
		String listaEspias = "Espias: ";
		String relaciones = "Relaciones: ";
		
		
		return listaEspias + espias.toString() + ". Relaciones: " + this.listaDeVecinos.toString(); 
	}
	
}