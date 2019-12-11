package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity {

	private String empName, email;
	private double salary;
	private LocalDate DOB;
	
	private Department dept;
	
	public Employee() {
		System.out.println("inside Employee CTOR");
	}

	@Column(name="emp_name", length = 30)
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name="email", unique = true, length = 30)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	@ManyToOne
	@JoinColumn(name="dept_id")
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", email=" + email + ", salary=" + salary + ", DOB=" + DOB
				+ ", getId()=" + getId() + "]";
	}
	
	
}
