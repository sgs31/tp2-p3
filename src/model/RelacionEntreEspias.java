package model;

public class RelacionEntreEspias{
		private Espia espia1;
		private Espia espia2;
		private Integer posibilidadDeIntercepcion;

		public RelacionEntreEspias(Espia espia1, Espia espia2) {
			this.espia1= espia1;
			this.espia2= espia2;
			this.posibilidadDeIntercepcion= espia1.getPosibilidadDeIntercepcion() + espia2.getPosibilidadDeIntercepcion();
		}

		public Integer obtenerPosibilidadDeIntercepcion() {
			return posibilidadDeIntercepcion;
		}
		public Espia getEspia1() {
			return espia1;
		}

		public Espia getEspia2() {
			return espia2;
		}
}
