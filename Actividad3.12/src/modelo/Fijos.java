package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//crea una clave foránea en Fijos como columna extra en la tabla que apunta a la clave primaria del padre (en este caso dni de empleados)
@PrimaryKeyJoinColumn(name="empleadosID")
public class Fijos extends Empleados implements Serializable{
	
	private int salarioBase;

	private int trienios;
	

	public int getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(int salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getTrienios() {
		return trienios;
	}

	public void setTrienios(int trienios) {
		this.trienios = trienios;
	}

	@Override
	public float calculoNomina() {
		float sueldo = (salarioBase+trienios)-(salarioBase+trienios)*super.getPorcentaRetencion();
		return sueldo;
	}
	
	

}
