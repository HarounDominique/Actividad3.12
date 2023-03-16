package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import modelo.Empleados;
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
		
		Empresas empresa2 = new Empresas();
		empresa2.setCif("22220");
		empresa2.setDirección("Pontevedra");
		empresa2.setNombre("MyCompany2");
		empresa2.setTelefono("654987321");

		empresaServicio.create(empresa2);
		
		Empresas empresa3 = new Empresas();
		empresa3.setCif("33330");
		empresa3.setDirección("Lugo");
		empresa3.setNombre("MyCompany3");
		empresa3.setTelefono("654654987");

		empresaServicio.create(empresa3);

		Fijos fijo1 = new Fijos();
		fijo1.setDni("123456");
		fijo1.setNombre("Yo soy fijo");
		fijo1.setPorcentaRetencion(0.2f);
		fijo1.setSalarioBase(30000);
		fijo1.setTelefono("321654987");
		fijo1.setTrienios(0);
		fijo1.setEmpresa(empresa);
		
		Fijos fijo2 = new Fijos();
		fijo2.setDni("123456B");
		fijo2.setNombre("Yo soy fijo2");
		fijo2.setPorcentaRetencion(0.2f);
		fijo2.setSalarioBase(30000);
		fijo2.setTelefono("321654987");
		fijo2.setTrienios(0);
		fijo2.setEmpresa(empresa2);
		
		Fijos fijo3 = new Fijos();
		fijo3.setDni("123456C");
		fijo3.setNombre("Yo soy fijo2");
		fijo3.setPorcentaRetencion(0.2f);
		fijo3.setSalarioBase(30000);
		fijo3.setTelefono("321654987");
		fijo3.setTrienios(0);
		fijo3.setEmpresa(empresa3);

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
		empleadoServicio.create(fijo2);
		empleadoServicio.create(fijo3);
		empleadoServicio.create(temp);
		/*

		try {
			empleadoServicio.delete("321654987");
		} catch (Exception e) {
			System.out.println("Ha ocurrido una excepción " + e.getMessage());
			// e.printStackTrace();
		}
		*/
		

		List<Empresas> empresas = empresaServicio.getEmpresasYEmpleados();
		Set<Empleados> empleados;
		for (Empresas cia : empresas) {
			System.out.println(cia);
			empleados = cia.getEmpleados();
			for (Empleados empleado : empleados) {
				System.out.println(empleado);
			}
		}
		

//		String cif = "11110";
//		try {
//			if (empresaServicio.delete(cif)) {
//				System.out.println("Borrado de empresa exitoso.");
//			}
//		} catch (Exception e) {
//			System.out.println("Ha ocurrido una exepción en el borrado de la empresa." + e.getMessage());
//		}
	}
}
