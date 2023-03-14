package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;

@Entity
@PrimaryKeyJoinColumn(name="empleadosID")
public class Temporales extends Empleados implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//esta movida no sé para qué es la verdad
	
	private LocalDate fechaInicio;
	
	private LocalDate fechaFin;

	private float pagoDia;

	private float suplemento;

	@Override
	public float calculoNomina() {
		long daysBetween = ChronoUnit.DAYS.between(fechaFin, fechaInicio);
		float sueldo = pagoDia*(daysBetween)-pagoDia*(daysBetween)*super.getPorcentaRetencion()+suplemento;
		return sueldo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getPagoDia() {
		return pagoDia;
	}

	public void setPagoDia(float pagoDia) {
		this.pagoDia = pagoDia;
	}

	public float getSuplemento() {
		return suplemento;
	}

	public void setSuplemento(float suplemento) {
		this.suplemento = suplemento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
