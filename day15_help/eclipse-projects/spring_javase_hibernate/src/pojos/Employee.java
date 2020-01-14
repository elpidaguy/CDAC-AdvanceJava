package pojos;
import javax.persistence.*;

@Entity
@Table(name="dac_emps")
public class Employee {
	private String name;
	private double salary;
	private EmpPK key;
	public Employee() {
		System.out.println("in emp def constr");
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
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
	@EmbeddedId
	public EmpPK getKey() {
		return key;
	}
	public void setKey(EmpPK key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", key=" + key + "]";
	}
	
	

}
