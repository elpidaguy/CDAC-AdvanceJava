package tester;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.app.dao.UserQueryDaoIntf;

public class TestNamedQuery {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC started....");
			UserQueryDaoIntf dao = ctx.getBean(UserQueryDaoIntf.class);
			dao.getUsersByNamedQuery().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
