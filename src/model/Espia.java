package model;

import java.util.Objects;

public class Espia {
	
	

	private String nombre;
	
	public Espia(String nombre) {
		this.nombre = nombre;	
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espia other = (Espia) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Espia [nombre=" + nombre + "]";
	}
}
