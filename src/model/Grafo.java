package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	private ArrayList<RelacionEntreEspias> relacionesEntreEspias;
	private ArrayList<Espia> espias;
	private int cantidadDeEspias;
	private HashMap<Espia, HashSet<Espia>> listaDeVecinos;
	private boolean[][] GrupoDeEspias;

	public Grafo(int cantidadDeEspias) {
		this.cantidadDeEspias = cantidadDeEspias;
		this.relacionesEntreEspias = new ArrayList<RelacionEntreEspias>();
		this.espias = new ArrayList<Espia>();
		this.listaDeVecinos = new HashMap<Espia, HashSet<Espia>>(cantidadDeEspias);
	}
	
	public Grafo(ArrayList<RelacionEntreEspias> e, int cantP) {
		this.relacionesEntreEspias=new ArrayList<RelacionEntreEspias>();
		this.espias= new ArrayList<Espia>();
		this.listaDeVecinos=new HashMap<Espia, HashSet<Espia>>();
		for (RelacionEntreEspias edge : e) {
			agregarRelacionEntreEspias(edge.getEspia1(), edge.getEspia2());
		}
		this.cantidadDeEspias=cantP;
	}
	

	public void agregarEspia(Espia espia1) {
		if (espias.size() == 0) {
			listaDeVecinos.put(espia1, new HashSet<Espia>());
			agregarALaListaDeEspias(espia1);

		} else {
			for (int i = 0; i < espias.size(); i++) {
				if (!espias.get(i).equals(espia1)) {
					agregarRelacionEntreEspias(espias.get(i), espia1);
				}
			}

		}
	}

	private void agregarRelacionEntreEspias(Espia espia1, Espia espia2) {
		chequearSiEsElMismoEspia(espia1, espia2);
		if (!chequearExistenciaDeRelacion(espia1, espia2) && !chequearExistenciaDeRelacion(espia2, espia1)) {
			agregarAListaDeVecinos(espia1, espia1);
			agregarAListaDeVecinos(espia2, espia1);
			relacionesEntreEspias.add(new RelacionEntreEspias(espia1, espia2));
			agregarEspia(espia1);
			agregarEspia(espia2);
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

	public boolean chequearExistenciaDeEspia(Espia espia1) {
		return listaDeVecinos.containsKey(espia1);
	}

	public boolean chequearExistenciaDeRelacion(Espia espia1, Espia espia2) {
		return relacionesEntreEspias.contains(new RelacionEntreEspias(espia1, espia2));
	}

	private void chequearSiEsElMismoEspia(Espia espia1, Espia espia2) {
		if (espia1.equals(espia2))
			throw new IllegalArgumentException("Un espía no puede enviarse el mensaje a sí mismo.");
	}

	private void agregarALaListaDeEspias(Espia espia1) {
			if (!espias.contains(espia1)) {
				espias.add(espia1);
			}
		}

	public ArrayList<RelacionEntreEspias> getRelacionesEntreEspias() {
		return relacionesEntreEspias;
	}

	public ArrayList<Espia> getEspias() {
		return espias;
	}

	public int getCantidadDeEspias() {
		return cantidadDeEspias;
	}

	public HashMap<Espia, HashSet<Espia>> getListaDeVecinos() {
		return listaDeVecinos;
	}
	
	public Espia getEspiaEspecifico(int i) {
		return espias.get(i);
	}
	
	public int indiceEspia(Espia e) {
		return espias.indexOf(e);
	}
	
	public Set<Espia> DameVecinosDeUnEspia(Espia p){
		
		Set<Espia> ret= new HashSet<Espia>();
		
		if(chequearExistenciaDeEspia(p)) 
			ret=listaDeVecinos.get(p);
		
		return ret;
	}
	
	public int getCantidadDeRelaciones() {
		return relacionesEntreEspias.size();
	}
}