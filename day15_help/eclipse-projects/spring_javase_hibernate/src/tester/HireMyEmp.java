package tester;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.dao.MyEmpDaoIntf;

import pojos.MyEmp;

public class HireMyEmp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml")
				)
		{
			System.out.println("SC started");
			System.out.println("Enyer emp dtls nm city dept sal");
			MyEmp e=new MyEmp(sc.next(), sc.next(),sc.next(),sc.nextDouble());
				//get dao layer bean
			MyEmpDaoIntf dao=ctx.getBean("myEmpDao",MyEmpDaoIntf.class);
			System.out.println(dao.hireEmp(e));
		
		}

	}

}
