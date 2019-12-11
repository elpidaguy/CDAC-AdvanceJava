package utils;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		try {
			System.out.println("in static init block");
			// reg
			StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
			sf = new MetadataSources(reg).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSf() {
		return sf;
	}
	

}
