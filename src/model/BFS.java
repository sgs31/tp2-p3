package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	private static boolean [] espiasDefinidos;
	private static ArrayList<Espia> ListaDeEspiasBFS;
	
	private static void RecorridoBFS(Grafo g, Espia espiaOrigen) {
		ListaDeEspiasBFS = new ArrayList<Espia>();
		ListaDeEspiasBFS.add(espiaOrigen);
		espiasDefinidos= new boolean[g.getCantidadDeEspias()];
	}
	
	
	public static boolean esConexo(Grafo g) {
		if(g==null) {
			throw new IllegalArgumentException("El grafo es no existe.");

		}
		if(g.getCantidadDeEspias()==0) {
			return true;
		}
		return alcanzables(g, g.getEspia(0)).size()==g.getCantidadDeEspias();
			
	}
	
	public static Set<Espia> alcanzables(Grafo g, Espia espiaOrigen){
		Set<Espia> ret= new HashSet<Espia>();
		RecorridoBFS(g, espiaOrigen);
		
		while(ListaDeEspiasBFS.size()>0) {
			Espia i=ListaDeEspiasBFS.get(0);
			espiasDefinidos[g.indiceEspia(i)]=true;
			ret.add(i);
			
			agregarVecinosPendientes(g, i);
			ListaDeEspiasBFS.remove(0);
			
		}
		return ret;
	}

	private static void agregarVecinosPendientes(Grafo g, Espia i) {

		for (Espia espia : g.getVecinosDeUnEspia(i)) {
			
		if (espiasDefinidos[g.indiceEspia(espia)] == false && !ListaDeEspiasBFS.contains(espia)) 
			ListaDeEspiasBFS.add(espia);	
		
		}	
	}	
}
	
