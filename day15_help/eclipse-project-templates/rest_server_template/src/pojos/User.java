package pojos;

import java.util.Date;

public class User {
	private Integer id;
	private String name,email,password,role;
	private double regAmount;
	private Date regDate;
	
	public User() {
		System.out.println("in vendor constr");
	}

	public User(Integer id, String name, String email, String password, String role, double regAmount, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	
	
	
		
}
