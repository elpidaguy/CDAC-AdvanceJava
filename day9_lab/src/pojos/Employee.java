package pojos;

import javax.persistence.*;

@Entity
@Table(name="dac_emps")
public class Employee extends AbstractEntity {

	@Column(length=30, unique=true)
	private String name;
	private double salary;
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department dept;
	
	public Employee() {
		System.out.println("in Employee CTOR");
	}
	
	
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", Empolyee ID=" + getId() + "]";
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Employee)
		{
			Employee e=(Employee)o;
			if(getId().equals(e.getId()))
				return true;
		}
		return false;			
	}

	
	
	
}
