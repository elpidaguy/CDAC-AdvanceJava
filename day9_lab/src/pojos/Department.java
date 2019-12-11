package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="dac_depts")
public class Department extends AbstractEntity {
	
	@Column(length=30 ,unique = true)
	private String name;
	@Column(length=20)
	private String location;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> emps =  new ArrayList<>();

	public Department() {
		System.out.println("in Department CTOR");
	}
	
	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + ", Department ID=" + getId() + "]";
	}
	
	public void addEmployee(Employee e)
	{
		emps.add(e);//dept>--->emp
		e.setDept(this);//emp>--->dept
	}
	
	public void removeEmployee(Employee e)
	{
		emps.remove(e);
		e.setDept(null);
	}
}
