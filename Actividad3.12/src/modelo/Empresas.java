package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Empresas implements Serializable{
	
	private String cif;

	private String nombre;

	private String dirección;

	private String teléfono;

	private Set<Empleados> empleados = new HashSet<>();

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public Set<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleados> empleados) {
		this.empleados = empleados;
	}
	

}
