package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ObjetoArista implements Comparable<ObjetoArista>{

		private String espia1;
		private String espia2;
		private Integer posibilidadDeIntercepcion;

		public ObjetoArista(String espia1, String espia2, Integer posibilidadDeIntercepcion ) {
			this.espia1= espia1;
			this.espia2= espia2;
			this.posibilidadDeIntercepcion = posibilidadDeIntercepcion;
		}
		
		public ObjetoArista() {
			espia1 = null;
			espia2 = null;
			posibilidadDeIntercepcion = null;
		}
		
		public String getEspia1() {
			return espia1;
		}
		
		public String getEspia2() {
			return espia2;
		}
		
		public ObjetoArista setEspia1(String espia1) {
			this.espia1 = espia1;
			return this;
		}

		public ObjetoArista setEspia2(String espia2) {
			this.espia2 = espia2;
			return this;
		}

		public ObjetoArista setPosibilidadDeIntercepcion(Integer posibilidadDeIntercepcion) {
			this.posibilidadDeIntercepcion = posibilidadDeIntercepcion;
			return this;
		}

		public Integer getPosibilidadDeIntercepcion() {
			return posibilidadDeIntercepcion;
		}
		
		public boolean isEspiaEnRelacion(String espia) {
			Set<String> temp = new HashSet<String>();
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
			return isEspiaEnRelacion(other.getEspia1()) && isEspiaEnRelacion(other.getEspia2());
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
			return espia1 + " y " + espia2 + " | posibilidad de ser interceptado: %" + posibilidadDeIntercepcion;
		}
		
		public String toStringSinIntercepcion() {
			return espia1 + " <---> " + espia2;
		}		
}
