package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.CourseServiceImpl;
import com.app.service.ICourseService;

public class CourseSelection {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml")) {
			System.out.println("SC started...");
			System.out.println("Enter student id n course id");
			// get rdy to use service bean from SC
			ICourseService service = ctx.getBean("courseServiceImpl", ICourseService.class);
			// invoke service 's method.
			System.out.println("status " + service.selectCourse(sc.nextInt(), sc.nextInt()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
