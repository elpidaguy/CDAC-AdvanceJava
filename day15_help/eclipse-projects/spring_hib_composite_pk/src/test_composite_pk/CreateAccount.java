package test_composite_pk;

import java.util.Scanner;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.*;
import com.app.service.*;


public class CreateAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ctx loaded");

		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml");) {
			AccountService service=ctx.getBean(AccountService.class);
			System.out.println("Enter Account details -- name type bal");
			Account a = new Account(sc.next(), sc.next(), sc.nextDouble());
			System.out.println("Enter Account id & branch id");
			AccountPK pk=new AccountPK(sc.nextInt(),sc.nextInt());
			a.setId(pk);
			service.createAccount(a);
			System.out.println("Account created successfully...." + a);
			} catch (Exception e) {
		//	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
