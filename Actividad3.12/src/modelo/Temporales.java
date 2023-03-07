package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Temporales extends Empleados implements Serializable{
	
	private LocalDate fechaInicio;

	private LocalDate fechaFin;

	private float pagoDia;

	private float suplemento;

	@Override
	public float calculoNomina() {
		long daysBetween = ChronoUnit.DAYS.between(fechaFin, fechaInicio);
		float sueldo = pagoDia*(daysBetween)-pagoDia*(daysBetween)*super.getPorcentaRetención()+suplemento;
		return sueldo;
	}
	
	

}
