package servicio;

import javax.management.InstanceNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empleados;
import util.SessionFactoryUtil;

public class EmpleadoServicio implements IEmpleadoServicio {

	@Override
	public Empleados create(Empleados empleado) {

		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// transaction se importa desde hibernate, no desde javax
		Transaction tx = null;
		try (Session sesion = sf.openSession();) {
			tx = sesion.beginTransaction();
			sesion.save(empleado);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido una excepción intentando guardar el empleado.");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			empleado = null;
		}
		return empleado;
	}

	@Override
	public boolean delete(String dni) throws Exception {

		boolean exito = false;
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		// transaction se importa desde hibernate, no desde javax
		Transaction tx = null;
		try (Session sesion = sf.openSession();) {
			tx = sesion.beginTransaction();
			Empleados empleado = sesion.get(Empleados.class, dni);
			if (empleado != null) {
				sesion.remove(empleado);
			} else {
				throw new InstanceNotFoundException(Empleados.class.getName());
			}
			tx.commit();
			exito = true;
			System.out.println("Borrado exitoso.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido una excepción intentando eliminar el empleado");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			// para propagar la excepción a la vista y que el main de el error al usuario
			// debemos poner un throw
			throw e;
		}
		return exito;
	}
}
