package model;

public class Espia {
	
	private int numeroDeEspia;
	private int posibilidadDeIntercepcion;
	
	public Espia(int numeroDeEspia, int posibilidadDeIntercepcion) {
		this.numeroDeEspia = numeroDeEspia;
		this.posibilidadDeIntercepcion = posibilidadDeIntercepcion;
	}

	public int getNumeroDeEspia() {
		return numeroDeEspia;
	}

	public int getPosibilidadDeIntercepcion() {
		return posibilidadDeIntercepcion;
	}


}
