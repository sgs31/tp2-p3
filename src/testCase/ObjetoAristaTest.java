package testCase;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

import model.ObjetoArista;

public class ObjetoAristaTest {
	
	ArrayList<ObjetoArista> relaciones;
	
	@Before
	public void init() {
		relaciones = new ArrayList<>();
		relaciones.add(new ObjetoArista("Carlos","Vale", 9));
		relaciones.add(new ObjetoArista("Agustin", "Carlos", 8));
		relaciones.add(new ObjetoArista("Mica","Fran", 7));
		relaciones.add(new ObjetoArista("Fran","Javier", 3));
		relaciones.add(new ObjetoArista("Mica","Jorge", 8));
	}
	
	@Test
	public void tamanoDeRelacionesTest() {
		assertEquals(5, relaciones.size());
		relaciones.remove(0);
		assertEquals(4, relaciones.size());
	}
	
	@Test
	public void isEspiaEnRelacionTrueTest() {
		assertTrue(relaciones.get(2).isEspiaEnRelacion("Mica"));
		assertTrue(relaciones.get(4).isEspiaEnRelacion("Mica"));
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
