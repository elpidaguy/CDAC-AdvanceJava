package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class StudentDTO {
	private Integer id;
	@NotEmpty(message="Name must be suuplied")
	private String name;
	@NotEmpty(message="Email must be suuplied")
	@Email (message="Invalid email  fromat")
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{4,10})",message="Invalid password")
	private String password;
	@NotNull(message="Fees must be supplied")
	@Range(min=5000,max=50000,message="Invalid fees")
	private double fees;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	public StudentDTO() {
		System.out.println("stud dto constr");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", fees="
				+ fees + ", dob=" + dob + "]";
	}
	

}
