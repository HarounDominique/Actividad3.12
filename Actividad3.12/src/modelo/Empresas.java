package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
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
	//podría ponerse además de mappedBy fetch (por defecto es LAZY) a EAGER. para que importe todos los datos en el proxy
	//En el onetomany también se puede añadir el cascade (en este caso de tipo remove para que cada vez que borremos una empresa se borren todos sus empleados)
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.REMOVE)
	@BatchSize(size=2)
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

	@Override
	public String toString() {
		return "Empresas [cif=" + cif + ", nombre=" + nombre + ", dirección=" + dirección + ", telefono=" + telefono
				+ ", empleados=" + empleados + "]";
	}

	public Set<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleados> empleados) {
		this.empleados = empleados;
	}
	

}
