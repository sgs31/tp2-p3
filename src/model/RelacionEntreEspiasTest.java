package model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class RelacionEntreEspiasTest {
	
	ArrayList<ObjetoArista> relaciones;
	
	@Before
	public void init() {
		relaciones = new ArrayList<>();
		relaciones.add(new ObjetoArista(new Espia("Carlos"), new Espia("Vale"), 9));
		relaciones.add(new ObjetoArista(new Espia("Agustin"), new Espia("Carlos"), 8));
		relaciones.add(new ObjetoArista(new Espia("Mica"), new Espia("Fran"), 7));
		relaciones.add(new ObjetoArista(new Espia("Fran"), new Espia("Javier"), 3));
		relaciones.add(new ObjetoArista(new Espia("Mica"), new Espia("Jorge"), 8));
	}
	
	@Test
	public void tamanoDeRelacionesTest() {
		assertEquals(5, relaciones.size());
		relaciones.remove(0);
		assertEquals(4, relaciones.size());
	}
	
	@Test
	public void isEspiaEnRelacionTrueTest() {
		Espia Mica = new Espia("Mica");
		assertTrue(relaciones.get(2).isEspiaEnRelacion(Mica));
		assertTrue(relaciones.get(4).isEspiaEnRelacion(Mica));
	}
	
	@Test
	public void ordenamientoDeRelacionesPorSuPeso() {
		Collections.sort(relaciones);
		assertEquals((Integer) 3, relaciones.get(0).getPosibilidadDeIntercepcion());
		assertEquals((Integer) 7, relaciones.get(1).getPosibilidadDeIntercepcion());
		assertEquals((Integer) 8, relaciones.get(2).getPosibilidadDeIntercepcion());
		assertEquals((Integer) 8, relaciones.get(3).getPosibilidadDeIntercepcion());
		assertEquals((Integer) 9, relaciones.get(4).getPosibilidadDeIntercepcion());
	}

}
