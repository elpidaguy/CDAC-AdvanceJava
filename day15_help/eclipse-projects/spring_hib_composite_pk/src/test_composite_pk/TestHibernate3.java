package test_composite_pk;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.*;
import com.app.service.*;


public class TestHibernate3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		System.out.println("ctx loaded");

		try {
			AccountService service=ctx.getBean(AccountService.class);
			
			
			System.out.println("Enter Account id & branch id");
			
			
			Account a= service.getAccount(sc.nextInt(),sc.nextInt());
			System.out.println("Account summary " + a);
			System.out.println("Enter new balance");
			a.setBal(sc.nextDouble());
			System.out.println(service.updateAccount(a));
			
	

		} catch (Exception e) {
		//	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
