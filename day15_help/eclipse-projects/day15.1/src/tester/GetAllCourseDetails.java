package tester;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.Course;
import com.app.service.CourseServiceImpl;
import com.app.service.ICourseService;

public class GetAllCourseDetails {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml")) {
			System.out.println("SC started...");
			// get rdy to use service bean from SC
			ICourseService service = ctx.getBean("courseServiceImpl", ICourseService.class);
			// invoke service 's method.
			List<Course> allCourses = service.getAllCourses();
			allCourses.forEach(c -> {
				System.out.println(c.getName() + " " + c.getFees());
				System.out.println("Students : ");
				c.getStudents().forEach(System.out::println);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
