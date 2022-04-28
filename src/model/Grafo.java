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

	public Grafo() {
		this.cantidadDeEspias = 0;
		this.relacionesEntreEspias = new ArrayList<RelacionEntreEspias>();
		this.espias = new ArrayList<Espia>();
		this.listaDeVecinos = new HashMap<Espia, HashSet<Espia>>();
	}
	
	public boolean agregarEspia(String nombre) {
		Espia aux = new Espia(nombre);
		if(espias.contains(aux)) return false;
		espias.add(aux);
		return true;
	}
	
	public void agregarRelacionEntreEspias(Espia espia1, Espia espia2, Integer peso) {
		if(espia1.equals(espia2)) {
			throw new IllegalArgumentException("Un esp�a no puede enviarse el mensaje a s� mismo.");
		}
		
		RelacionEntreEspias temp = new RelacionEntreEspias(espia1, espia2, peso);
		
		if(!relacionesEntreEspias.contains(temp)){
			relacionesEntreEspias.add(temp);
			agregarVecinoAlNinja(espia1, espia2);
			agregarVecinoAlNinja(espia2, espia1);
		}
	}
	
	private void agregarVecinoAlNinja(Espia espia1, Espia espia2) {
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

	public ArrayList<RelacionEntreEspias> getRelacionesEntreEspias() {
		ArrayList<RelacionEntreEspias> temp = (ArrayList<RelacionEntreEspias>) relacionesEntreEspias.clone();
		return temp;
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
	//por que un espia deberia tener un id o un indice? 
	public int indiceEspia(Espia e) {
		return espias.indexOf(e);
	}
	
	//de ser que el espia tenga sus vecinos, se lo preguntamos a el
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