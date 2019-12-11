package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

public class BasicTester {
	
	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {

			System.out.println("HIbernate Booted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
