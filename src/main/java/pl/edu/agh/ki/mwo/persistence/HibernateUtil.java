package pl.edu.agh.ki.mwo.persistence;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{
		try{
			System.out.println("Jestem w try:");
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch (Exception e) {
			System.out.println("Jestem w exception:");
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown(){
		getSessionFactory().close();
	}
}
