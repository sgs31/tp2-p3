package model;

public class Prueba {

	public static void main(String[] args) {
		
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
		
		System.out.print(g.toString());
		
		Kruskal k = new Kruskal(g);
		k.arbolGeneradorMinimo();
		
		System.out.print(k.toString());
		
	}

}
