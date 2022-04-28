package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RelacionEntreEspias{
		private Espia espia1;
		private Espia espia2;
		private Integer posibilidadDeIntercepcion;

		public RelacionEntreEspias(Espia espia1, Espia espia2, Integer posibilidadDeIntercepcion ) {
			this.espia1= espia1;
			this.espia2= espia2;
			this.posibilidadDeIntercepcion = posibilidadDeIntercepcion;
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

		@Override
		public int hashCode() {
			return Objects.hash(espia1, espia2, posibilidadDeIntercepcion);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RelacionEntreEspias other = (RelacionEntreEspias) obj;
			Set<Espia> temp = new HashSet<>();
			temp.add(this.espia1);
			temp.add(this.espia2);
			return temp.contains(other.espia1) && temp.contains(other.espia2);
		}

		
}
