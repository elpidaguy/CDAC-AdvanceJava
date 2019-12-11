package tester;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import dao.CustomerDaoImpl;
import pojos.Customer;

public class CustomerTesterLayered {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			CustomerDaoImpl cdi = new CustomerDaoImpl();
			boolean exit = false;
			
			while(!exit)
			{
				System.out.println("MENU");
				System.out.println("1.Login");
				System.out.println("2.Register");
				System.out.println("3.Display Customers");
				System.out.println("4.exit");
				System.out.println("Choose Option: ");
				
				switch (sc.nextInt()) {
				case 1:
					Customer cs = cdi.signIn(sc.next(), sc.next());
					System.out.println("Login Successfull"+ cs);
					break;
				case 2:
					String result = cdi.signUp(new Customer(sc.next(),sc.next(),sc.nextDouble(),Date.valueOf(LocalDate.now())));
					System.out.println(result);
				case 3:
					HashMap<Integer,Customer> hmCust = cdi.getCustomers();
					System.out.println(hmCust);
				case 4:
					exit = true;
				default:
					break;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
