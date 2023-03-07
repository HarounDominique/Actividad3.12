package modelo;

import java.io.Serializable;

public abstract class Empleados implements Serializable{
	
	private String dni;

	private String nombre;

	private String teléfono;

	private float porcentaRetención;
	
	
	public abstract float calculoNomina();

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public float getPorcentaRetención() {
		return porcentaRetención;
	}

	public void setPorcentaRetención(float porcentaRetención) {
		this.porcentaRetención = porcentaRetención;
	}
	
	

}
