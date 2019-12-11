package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {
	
	Integer id;
	String name,email,password,city,phone;
	double regAmount;
	LocalDate regDate;
	
	public Vendor() {
		
		System.out.println("Default CTOR Called");
	}
	

	public Vendor(String name, String email, String password, String city, String phone, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phone = phone;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 40)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 15)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 10)
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Column(length = 20)
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Vendor [name=" + name + ", email=" + email + ", city=" + city + ", phone=" + phone + ", regAmount="
				+ regAmount + ", regDate=" + regDate + "]";
	}

	
	
}
