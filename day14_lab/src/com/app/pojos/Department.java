package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department extends AbstractEntity{
	
	private String deptName, location;
	private int strength;
	
	private List<Employee> empList;
	
	public Department() {
		System.out.println("inside Department CTOR");
	}

	@Column(name="dept_name", length=15)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	public void addEmployee(Employee e)
	{
		empList.add(e);
		e.setDept(this);
	}
	
	public void removeEmployee(Employee e)
	{
		empList.remove(e);
		e.setDept(null);
	}
	
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", location=" + location + ", strength=" + strength + ", getId()="
				+ getId() + "]";
	}
	

}
