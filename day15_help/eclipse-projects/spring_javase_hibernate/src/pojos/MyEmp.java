package pojos;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="dac_emps2")
public class MyEmp {
	private String empId;
	private String name,city,dept;
	private double salary;
	
	public MyEmp() {
		System.out.println("in emp def constr");
	}
	
	
	
	public MyEmp(String name, String city, String dept, double salary) {
		super();
		this.name = name;
		this.city = city;
		this.dept = dept;
		this.salary = salary;
	}


	@Id
	@Column(length=30)
	@GenericGenerator(name = "emp_custom_id", strategy = "id_gen.EmpIdGenerator")
    @GeneratedValue(generator = "emp_custom_id")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}


	@Column(length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Column(length=10)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(columnDefinition="double(7,1)")
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "MyEmp [empId=" + empId + ", name=" + name + ", city=" + city + ", dept=" + dept + ", salary=" + salary
				+ "]";
	}
	
	
	
	

}
