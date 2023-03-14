package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//Para que sea clase POJO debe implementar serializable
@Entity
@Table(name="empresa")
public class Empresas implements Serializable{
	
	//la anotación del ID de la tabla lo colocamos en el getter del campo que es la clave o en el propio campo (atributo)
	@Id
	//column establece el nombre con el que este campo aparece en la tabla, y el length establece una restricción 
	@Column(name="empresaCIF", length = 15)
	private String cif;

	private String nombre;

	private String dirección;

	private String telefono;
	//esto se debe a que en la relación entre empresa y empleados, empresa es el lado uno, y empleados el lado muchos. Por defecto oneToMany es Lazy
	//el one to many SIEMPRE LLEVA EL MAPPED BY, CON EL ATRIBUTO DEL LADO CONTRARIO QUE PERMITE NAVEGAR AQUÍ
	@OneToMany(mappedBy = "empresa")
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String teléfono) {
		this.telefono = teléfono;
	}

	public Set<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleados> empleados) {
		this.empleados = empleados;
	}
	

}
