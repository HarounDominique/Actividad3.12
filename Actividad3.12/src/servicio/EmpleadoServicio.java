package servicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empleados;
import util.SessionFactoryUtil;

public class EmpleadoServicio implements IEmpleadoServicio{

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
			System.out.println("Ha ocurrido una excepción!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			empleado = null;
		}
		return empleado;
	}
	
}
