package Hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HinernateUtil {
	private static final SessionFactory sesionFactory= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		SessionFactory sesionFactory=null;
		try {
			return (SessionFactory) new Configuration();

		}catch(Exception e){

			e.printStackTrace();
		}
		return sesionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sesionFactory;

	}
}
