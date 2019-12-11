package pojos;

import java.sql.Date;

public class Customer {
	
	int id;
	String email,password;
	double reg_amt;
	Date reg_date;
	public Customer(int id, String email, String password, double reg_amt, Date reg_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.reg_amt = reg_amt;
		this.reg_date = reg_date;
	}
	
	public Customer(int id, String email, double reg_amt, Date reg_date)
	{
		super();
		this.id=id;
		this.email = email;
		this.reg_amt = reg_amt;
		this.reg_date = reg_date;
	}
	
	public Customer(String email, String password, double reg_amt, Date reg_date) {
		super();
		this.email = email;
		this.reg_amt = reg_amt;
		this.reg_date = reg_date;
	}

	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public double getReg_amt() {
		return reg_amt;
	}
	public Date getReg_date() {
		return reg_date;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", password=" + password + ", reg_amt=" + reg_amt
				+ ", reg_date=" + reg_date + "]";
	} 

	
}
