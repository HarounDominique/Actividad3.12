package main;

import java.time.LocalDate;

import modelo.Empresas;
import modelo.Fijos;
import modelo.Temporales;
import servicio.EmpleadoServicio;
import servicio.EmpresaServicio;
import servicio.IEmpleadoServicio;
import servicio.IEmpresaServicio;

public class Main {
	
	private static IEmpresaServicio empresaServicio = new EmpresaServicio();
	private static IEmpleadoServicio empleadoServicio = new EmpleadoServicio();

	public static void main(String[] args) {
		
		Empresas empresa = new Empresas();
		empresa.setCif("11110");
		empresa.setDirección("Vigo");
		empresa.setNombre("MyCompany");
		empresa.setTelefono("321654987");
		
		empresaServicio.create(empresa);
		
		
		Fijos fijo1 = new Fijos();
		fijo1.setDni("123456");
		fijo1.setNombre("Yo soy fijo");
		fijo1.setPorcentaRetencion(0.2f);
		fijo1.setSalarioBase(30000);
		fijo1.setTelefono("321654987");
		fijo1.setTrienios(0);
		fijo1.setEmpresa(empresa);
		
		
		Temporales temp = new Temporales();
		temp.setDni("321654987");
		temp.setPorcentaRetencion(0.2f);
		temp.setTelefono("321654987");
		temp.setNombre("Soy el temporal");
		temp.setEmpresa(empresa);
		temp.setFechaInicio(LocalDate.of(2023, 1, 1));
		temp.setFechaFin(LocalDate.of(2023, 3, 3));
		temp.setPagoDia(90);
		temp.setSuplemento(50.2f);		
		
		
		empleadoServicio.create(fijo1);
		empleadoServicio.create(temp);
	}
}
