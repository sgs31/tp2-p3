package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ObjetoArista implements Comparable<ObjetoArista>{

		private Espia espia1;
		private Espia espia2;
		private Integer posibilidadDeIntercepcion;

		public ObjetoArista(Espia espia1, Espia espia2, Integer posibilidadDeIntercepcion ) {
			this.espia1= espia1;
			this.espia2= espia2;
			this.posibilidadDeIntercepcion = posibilidadDeIntercepcion;
		}
		
		public ObjetoArista() {
			espia1 = null;
			espia2 = null;
			posibilidadDeIntercepcion = null;
		}
		
		public Espia getEspia1() {
			return espia1;
		}
		
		public Espia getEspia2() {
			return espia2;
		}
		
		public Integer getPosibilidadDeIntercepcion() {
			return posibilidadDeIntercepcion;
		}
		
		public ObjetoArista setEspia1(Espia espia1) {
			this.espia1 = espia1;
			return this;
		}
		public ObjetoArista setEspia2(Espia espia2) {
			this.espia2 = espia2;
			return this;
		}
		public ObjetoArista setPosibilidadDeIntercepcion(Integer posibilidadDeIntercepcion) {
			this.posibilidadDeIntercepcion = posibilidadDeIntercepcion;
			return this;
		}
		
		public boolean isEspiaEnRelacion(Espia espia) {
			Set<Espia> temp = new HashSet<Espia>();
			temp.add(this.espia1);
			temp.add(this.espia2);
			return temp.contains(espia);
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
			ObjetoArista other = (ObjetoArista) obj;
			return isEspiaEnRelacion(other.espia1) && isEspiaEnRelacion(other.espia2);
		}

		@Override
		public int compareTo(ObjetoArista o) {
			if(getPosibilidadDeIntercepcion() < o.getPosibilidadDeIntercepcion())
				return -1;
			else if (getPosibilidadDeIntercepcion() == o.getPosibilidadDeIntercepcion())
				return 0;
			else
				return 1;
		}
		
		@Override
		public String toString() {
			return "ObjetoArista [espia1=" + espia1 + ", espia2=" + espia2 + ", posibilidadDeIntercepcion="
					+ posibilidadDeIntercepcion + "]";
		}

		
}
