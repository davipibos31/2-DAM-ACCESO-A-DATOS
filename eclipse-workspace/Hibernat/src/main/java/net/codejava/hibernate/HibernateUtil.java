package net.codejava.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sesionFactory= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
	SessionFactory sesionFactory=null;
	try {
	return new Configuration().configure().buildSessionFactory();

	}catch(Exception e){

	e.printStackTrace();
	}
	return sesionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sesionFactory;

	}
}