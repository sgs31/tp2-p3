package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class BFSTest {

	private Grafo inicializarEjemplo() {
		Grafo g = new Grafo();
		g.agregarEspia("Tom");
		g.agregarEspia("Juan");
		g.agregarEspia("Sarah");
		g.agregarEspia("Emma");
		g.agregarRelacionEntreEspias("Tom", "Juan", 1);
		g.agregarRelacionEntreEspias("Tom", "Sarah", 1);
		g.agregarRelacionEntreEspias("Sarah", "Emma", 1);
		return g;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}

	@Test
	public void testVacio() {
		Grafo h = new Grafo();
		assertTrue(BFS.esConexo(h));
	}

	@Test
	public void testNoConexo() {
		Grafo g = inicializarEjemplo();
		g.agregarEspia("Peter");
		
		assertFalse(BFS.esConexo(g));
	}

	@Test
	public void testConexo() {
		Grafo g = inicializarEjemplo();
		g.agregarEspia("Julia");
		g.agregarRelacionEntreEspias("Emma", "Julia", 1);  
		assertTrue(BFS.esConexo(g));
	}

	@Test
	public void alcanzablesTest() {
		Grafo g = inicializarEjemplo();
		Set<String> alcanzables = BFS.alcanzables(g, "Tom");

		String[] esperado = { "Tom", "Juan", "Sarah", "Emma" };
		Assert.iguales(esperado, alcanzables);
	}

	@Test
	public void alcanzablesTodosTest() {
		Grafo g = inicializarEjemplo();
		g.agregarEspia("Julia");
		g.agregarRelacionEntreEspias("Emma", "Julia", 1);  

		Set<String> alcanzables = BFS.alcanzables(g, "Tom");

		String[] esperado = {"Tom", "Juan", "Sarah", "Emma", "Julia" };
		Assert.iguales(esperado, alcanzables);
	}

}
