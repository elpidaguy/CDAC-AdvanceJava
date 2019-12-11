package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;
import pojos.UserType;

public class RegisterUser {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getSf()) {
			
			System.out.println("Hibernate connection estblished");
			System.out.println("Enter User Details: Name, Email, Password, Role, Confirm Password, Registered Amount, Registeration Date, User Type");
			User u = new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()), UserType.valueOf(sc.next()));
			
			UserDaoImpl udi = new UserDaoImpl();
			System.out.println(udi.registerUser(u));
					
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
