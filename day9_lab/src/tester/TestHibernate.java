package tester;

import java.util.Scanner;

import dao.DepartmentDaoImpl;
import pojos.Department;
import pojos.Employee;


public class TestHibernate {

	public static void main(String[] args) {
		
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		
		boolean flag = true;
		try(Scanner sc = new Scanner(System.in))
		{
		while(flag)
		{
			System.out.println("Menu");
			System.out.println("1.Create Department");
			System.out.println("2.Hire Employee in Department");
			System.out.println("3.Display Employee by Department");
			System.out.println("4.Fire Employee");
			System.out.println("7.Exit");
			System.out.println("Enter Choice: ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter Details: ");
				System.out.println("name,location");
				Department d1 = new Department(sc.next(),sc.next());
				for(int i=0;i<3;i++)
				{
					System.out.println("name,sal");
					d1.addEmployee(new Employee(sc.next(), sc.nextDouble()));
				}
				
				System.out.println(ddi.createNewDeptDepartment(d1));
				
				break;
				
			case 2:
				System.out.println("Enter Department Id");
				int deptId = sc.nextInt();
				System.out.println("name,sal");
				System.out.println(ddi.hireEmp(deptId, new Employee(sc.next(), sc.nextDouble())));
				break;
			case 3:
				System.out.println("Enter Department Name: ");
				for(Employee e : ddi.listEmps(sc.next()))
				{
					System.out.println(e);
				}
				break;
				
			case 4:
				System.out.println("Enter Dept ID and Emp ID");
				System.out.println(ddi.fireEmp(sc.nextInt(), sc.nextInt()));
			
				break;
				
			case 7:
				flag=false;
				break;
				
			default:
				break;
			}
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
