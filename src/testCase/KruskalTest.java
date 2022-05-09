package testCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Grafo;
import model.Kruskal;

public class KruskalTest {
	
	public Grafo constructorGrafo() {
		
		Grafo g = new Grafo();
		
		g.agregarEspia("Agustin");
		g.agregarEspia("Elis");
		g.agregarEspia("Alfredo");
		g.agregarEspia("Alicia");
		g.agregarEspia("Jhon");
		g.agregarEspia("Pepa");
		g.agregarEspia("Doe");
		g.agregarRelacionEntreEspias("Agustin", "Elis", 3);
		g.agregarRelacionEntreEspias("Agustin", "Alfredo", 1);
		g.agregarRelacionEntreEspias("Agustin", "Alicia", 5);
		g.agregarRelacionEntreEspias("Agustin", "Jhon", 7);
		g.agregarRelacionEntreEspias("Alfredo", "Pepa", 2);
		g.agregarRelacionEntreEspias("Pepa", "Jhon", 8);
		g.agregarRelacionEntreEspias("Alicia", "Jhon", 3);
		g.agregarRelacionEntreEspias("Jhon", "Doe", 11);
		
		return g;
	}
	
	
	@Test
	public void cantidadDeAristasEnArbolMinimo() {
		
		Kruskal k = new Kruskal(constructorGrafo());
		Grafo arbolMinimo = k.arbolGeneradorMinimo();
		
		assertEquals(6,arbolMinimo.getCantidadDeRelaciones());
	}
	
}
