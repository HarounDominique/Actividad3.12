package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//inheritance hace referencia a la clase padre
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleados implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//al ser protected acceden a la ID las clases que heredan de empleados
	protected String dni;

	private String nombre;

	private String telefono;

	private float porcentaRetencion;
	//es el lado many, y además el lado propietario ya que cuya tabla tiene la columna que contiene la foreign key que mantiene la relación
	@ManyToOne(fetch = FetchType.LAZY)
	//Logra que la clave foránea sea el cif de la empresa?????????????????????????
	@JoinColumn(name="empresaID")
	private Empresas empresa;
	
	
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

	public float getPorcentaRetencion() {
		return porcentaRetencion;
	}

	public void setPorcentaRetencion(float porcentaRetencion) {
		this.porcentaRetencion = porcentaRetencion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
