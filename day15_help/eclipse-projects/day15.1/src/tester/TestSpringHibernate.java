package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringHibernate {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml")) {
			System.out.println("SC started...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
