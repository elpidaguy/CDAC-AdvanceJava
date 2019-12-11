package pojos;

import java.sql.Date;

public class Customer {
	private int id;
	private String email, pass;
	private double amount;
	private Date regDate;
	public Customer(int id, String email, String pass, double amount, Date regDate) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.amount = amount;
		this.regDate = regDate;
	}
	
	
	
	public Customer(String email, String pass, double amount, Date regDate) {
		super();
		this.email = email;
		this.pass = pass;
		this.amount = amount;
		this.regDate = regDate;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", amount=" + amount + ", regDate=" + regDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
