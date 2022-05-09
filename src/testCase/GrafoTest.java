package testCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Grafo;

public class GrafoTest {
	
	@Test
	public void cargarVerticesTest() {

		Grafo g = new Grafo();
		
		g.agregarEspia("Juan");
		
		assertEquals(1, g.getListaDeEspias().size());		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void cargarVerticeRepetidoTest(){
		
		Grafo g = new Grafo();
		
		g.agregarEspia("Juan");
		g.agregarEspia("Juan");
			
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void cargarNombreVacioTest(){
		
		Grafo g = new Grafo();
		
		g.agregarEspia("");
	}
	
	@Test
	public void agregarRelacionTest(){
		
		Grafo g = new Grafo();
		
		g.agregarEspia("Tom");
		g.agregarEspia("Juan");
		
		assertTrue(g.agregarRelacionEntreEspias("Tom", "Juan", 2));
		assertEquals(1, g.getCantidadDeRelaciones());		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarRelacionNegativaTest(){
		
		Grafo g = new Grafo();
		
		g.agregarEspia("Tom");
		g.agregarEspia("Juan");
		
		g.agregarRelacionEntreEspias("Tom", "Juan", -2);
	}
	
	@Test
	public void repetirRelacionTest(){
		
		Grafo g = new Grafo();
		
		g.agregarEspia("Tom");
		g.agregarEspia("Juan");
		g.agregarRelacionEntreEspias("Tom", "Juan", 2);
			
		assertFalse(g.agregarRelacionEntreEspias("Tom", "Juan", 2));
		assertFalse(g.agregarRelacionEntreEspias("Juan", "Tom", 2));
		assertEquals(1, g.getCantidadDeRelaciones());		
	}
	
	@Test
	public void chequearListaDeVecinosTest(){
		
		Grafo g = new Grafo();
		
		g.agregarEspia("Tom");
		g.agregarEspia("Juan");
		g.agregarRelacionEntreEspias("Tom", "Juan", 2);
			
		assertEquals(2, g.getListaDeVecinos().size());		
	}
	
	@Test
	public void agregarRelacionConEspiasNoIncluidasEnGrafo() {
		Grafo g = new Grafo();
		
		g.agregarRelacionEntreEspias("jose", "maria", 2);
		assertEquals(0,g.getListaDeVecinos().size());
	}
	
	
}