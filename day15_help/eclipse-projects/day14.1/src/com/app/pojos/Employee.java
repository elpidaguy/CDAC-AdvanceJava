package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "dac_employees")
@JsonIgnoreProperties(value = { "salary" })
public class Employee {
	@JsonProperty(value = "no")
	private Integer id;
	private String name, address;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private double salary;
	private byte[] image;

	public Employee() {
		System.out.println("in emp ctor");
	}

	public Employee(String name, String address, Date hireDate, double salary) {
		super();
		this.name = name;
		this.address = address;
		this.hireDate = hireDate;
		this.salary = salary;

	}
	

	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date")
	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", hireDate=" + hireDate + "]";
	}

}
