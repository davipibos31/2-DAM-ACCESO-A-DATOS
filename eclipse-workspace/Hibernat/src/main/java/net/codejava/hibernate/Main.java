package net.codejava.hibernate;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Sede empleado = new Sede();
		empleado.setId_sede(0);;
		empleado.setNom_sede(null);
		
		session.save(empleado);
		session.getTransaction().commit();
		session.close();
	}

}
