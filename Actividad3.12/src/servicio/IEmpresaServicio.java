package servicio;

import java.util.List;

import modelo.Empresas;

public interface IEmpresaServicio {
	public Empresas create(Empresas empresa);
	
	public List<Empresas> getEmpresasYEmpleados();
	
	public boolean delete(String cif) throws Exception;
}
