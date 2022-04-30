package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KruskalTest {
	
	
//	@Test
//	public void chequearCicloTrueTest() {
//		Grafo g = new Grafo();
//		
//		g.agregarRelacionEntreEspias("Agustin", "Alfredo", 1);
//		g.agregarRelacionEntreEspias("Alfredo", "Pepa", 2);
//		g.agregarRelacionEntreEspias("Pepa", "Jhon", 8);
//		g.agregarRelacionEntreEspias("Alicia", "Jhon", 3);
//		g.agregarRelacionEntreEspias("Agustin", "Alicia", 5);
//		ObjetoArista aux = new ObjetoArista(new Espia("Agustin"),new Espia("Alicia"),5);
//		boolean result = Kruskal.isAristaFormaCiclo(g.getRelacionesEntreEspias(), aux);
//		
//		assertTrue(result);
//	}
	
	@Test
	public void cantidadDeAristasEnArbolMinimo() {
		Grafo g = new Grafo();
		
		g.agregarRelacionEntreEspias("Agustin", "Elis", 3);
		g.agregarRelacionEntreEspias("Agustin", "Alfredo", 1);
		g.agregarRelacionEntreEspias("Agustin", "Alicia", 5);
		g.agregarRelacionEntreEspias("Agustin", "Jhon", 7);
		g.agregarRelacionEntreEspias("Alfredo", "Pepa", 2);
		g.agregarRelacionEntreEspias("Pepa", "Jhon", 8);
		g.agregarRelacionEntreEspias("Alicia", "Jhon", 3);
		g.agregarRelacionEntreEspias("Jhon", "Doe", 11);
		Kruskal k = new Kruskal(g);
		Grafo arbolMinimo = k.arbolGeneradorMinimo();
		assertEquals(6,arbolMinimo.getCantidadDeRelaciones());
	}
}
