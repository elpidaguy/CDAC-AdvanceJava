package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.Student;
import com.app.service.IStudentService;

public class GetStudentDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml")) {
			System.out.println("SC started...");
			System.out.println("Enter student id");
			// get rdy to use service bean from SC
			IStudentService service = ctx.getBean("studentServiceImpl", IStudentService.class);
			System.out.println("service : " + service.getClass().getName());
			Student s = service.getStudentDetails(sc.nextInt());
			if (s != null) {
				System.out.println(s.getClass().getName());
				System.out.println(s);
		//		System.out.println(s.getSelectedCourses());
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
