package com.app.pojos;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



/**
 * The persistent class for the MY_CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="my_customers")
public class Customer  {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double depositAmt;
	@NotEmpty
	@Email
	@Length(min=5,max=15)
	private String email;//="some email";
	private String name;
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[$#@%]).{5,10})")
	private String password;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date regDate;
	private String role;

	public Customer() {
		System.out.println("in cust constr");
	}
	


	public Customer(double depositAmt, String email, String name,
			String password, Date regDate, String role) {
		super();
		this.depositAmt = depositAmt;
		this.email = email;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
		this.role = role;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="deposit_amt",columnDefinition="decimal(6,1)")
	public double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="reg_date")
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "CustomerPOJO [id=" + id + ", depositAmt=" + depositAmt
				+ ", email=" + email + ", name=" + name + ", password="
				+ password + ", regDate=" + regDate + ", role=" + role + "]";
	}
	

}