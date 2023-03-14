package servicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
}
