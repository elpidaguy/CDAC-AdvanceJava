package com.app.pojos;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="sunbeam_custs")
public class Customer {
	private Integer id;
	//@NotEmpty(message="Name can't be blank")
	@Length(min=3,max=20,message="Invalid Name length")
	private String name;
	@NotEmpty
	@Email
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Blank or Invalid Password")
	private String pass;
	@NotEmpty
	private String role;
	@Range(min=500,max=5000,message="Invalid Reg amount")
	private double regAmount;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date regDate;

	public Customer() {
		System.out.println("in cust constr");
	}

	
	public Customer(String name, String email, String pass, String role, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}


	public Customer(Integer id, String name, String email, String pass, String role, double regAmount, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("in set email");
		this.email = email;
	}
	@Column(length=20)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(length=20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column(columnDefinition="double(6,1)",name="reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", role=" + role
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
