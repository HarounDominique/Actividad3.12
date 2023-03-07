package modelo;

import java.io.Serializable;

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
		float sueldo = (salarioBase+trienios)-(salarioBase+trienios)*super.getPorcentaRetención();
		return sueldo;
	}
	
	

}
