package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	
	private static boolean [] marcados;
	private static ArrayList<String> L;
	
	
	public static boolean esConexo(Grafo g) {
		if(g==null) {
			throw new IllegalArgumentException("El grafo es no existe.");

		}
		if(g.getCantidadDeEspias()==0) {
			return true;
		}
		return alcanzables(g, g.getEspia(0)).size()==g.getCantidadDeEspias();
			
	}
	
	public static Set<String> alcanzables(Grafo g, String espiaOrigen){
		Set<String> ret= new HashSet<String>();
		inicializar(g, espiaOrigen);
		
		while(L.size()>0) {
			String i=L.get(0);
			marcados[g.indiceEspia(i)]=true;
			ret.add(i);
			
			
			agregarVecinosPendientes(g, i);
			L.remove(0);
			
		}
		return ret;
	}
	
	private static void inicializar(Grafo g, String espiaOrigen) {
		L = new ArrayList<String>();
		L.add(espiaOrigen);
		marcados= new boolean[g.getCantidadDeEspias()];
	}

	private static void agregarVecinosPendientes(Grafo g, String i) {

		for (String espia : g.getVecinosDeUnEspia(i)) {
			
		if (marcados[g.indiceEspia(espia)] == false && !L.contains(espia)) 
			L.add(espia);	
		
		}	
	}	
}
	
