package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.dao.EmpDaoIntf;

import pojos.EmpPK;
import pojos.Employee;

public class HireEmp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml")
				)
		{
			System.out.println("SC started");
			System.out.println("Enyer emp dtls nm sal");
			Employee e=new Employee(sc.next(), sc.nextDouble());
			System.out.println("Enter emp id n dept id");
			e.setKey(new EmpPK(sc.next(), sc.next()));
			//get dao layer bean
			EmpDaoIntf dao=ctx.getBean("empDao",EmpDaoIntf.class);
			System.out.println(dao.hireEmp(e));
		
		}

	}

}
