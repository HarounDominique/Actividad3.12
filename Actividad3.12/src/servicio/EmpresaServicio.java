package servicio;

import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empleados;
import modelo.Empresas;
import util.SessionFactoryUtil;

public class EmpresaServicio implements IEmpresaServicio {

	@Override
	public Empresas create(Empresas empresa) {
		
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// transaction se importa desde hibernate, no desde javax
		Transaction tx = null;
		try (Session sesion = sf.openSession();) {
			tx = sesion.beginTransaction();
			sesion.save(empresa);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido una excepción!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			empresa = null;
		}
		return empresa;
	}

	@Override
	public List<Empresas> getEmpresasYEmpleados() {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		List<Empresas> empresas = new ArrayList<>();
		// transaction se importa desde hibernate, no desde javax
		Transaction tx = null;
		//NOTA: ESTA CONSULTA HQL SE TRAE TODOS LOS EMPLEADOS POR CADA EMPRESA
		try (Session sesion = sf.openSession();) {
			empresas = sesion.createQuery("SELECT e FROM Empresas e INNER JOIN fetch e.empleados ORDER BY e.nombre").list();
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido una excepción tratando de traer las empresas con sus empleados.");
		}
		return empresas;
	}

	@Override
	public boolean delete(String cif) throws Exception{
		boolean exito = false;
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// transaction se importa desde hibernate, no desde javax
		Transaction tx = null;
		try (Session sesion = sf.openSession();) {
			tx = sesion.beginTransaction();
			Empresas cia = sesion.get(Empresas.class, cif);
			if (cia != null) {
				sesion.remove(cia);
			} else {
				throw new InstanceNotFoundException(Empleados.class.getName());
			}
			tx.commit();
			exito = true;
			System.out.println("Borrado exitoso.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido una excepción intentando eliminar la empresa");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			// para propagar la excepción a la vista y que el main de el error al usuario debemos poner un throw y su respectivo throws Exception 
			throw e;
		}
		return exito;
	}
}
