package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {
	@NotEmpty(message = "Name can't be blank")
	private String name;
	@NotEmpty
	@Length(min = 5, max = 20)
	@Email(message = "Invalid Email format")
	private String email;
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid Password")
	private String password;
	@NotNull
	@Range(min = 100, max = 5000, message = "Invalid reg amount")
	private double regAmount;
	@NotNull(message="Date must be supplied")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	@NotNull(message="choose some role")
	private UserRole role;
	// one to many bi-dir
	private List<BankAccount> accounts = new ArrayList<>();

	public User() {
		System.out.println("in user ctor");
		this.name = "some nm";
	}

	public User(String name, String email, String password, double regAmount, Date regDate, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 30, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Enumerated(EnumType.STRING)
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	// convenience methods
	public void addAccount(BankAccount a) {
		accounts.add(a);
		a.setOwner(this);
	}

	public void removeAccount(BankAccount a) {
		accounts.remove(a);
		a.setOwner(null);
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", name=" + name + ", email=" + email + ", regAmount=" + regAmount + ", regDate="
				+ regDate + ", role=" + role + " version " + getVersion();
	}

}
