package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.utils.LocalDateDeserializer;
import com.app.utils.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "vendors")
public class Vendor {
	private Integer id;
	private String name;
	@NotEmpty(message = "Email must be supplied")
	@Email(message = "Invalid Email format")
	private String email;
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid password")
	private String password;
	@Length(min=4,max=20,message="Invalid city name")
	private String city;
	private String  phoneNo;
	@NotEmpty(message="role must be selected")
	private String  role;
	@NotNull(message = "reg amount required")
	@Range(min = 200, max = 5000, message = "invalid reg amount")
	private double regAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@JsonFormat(pattern= "yyyy-MM-dd")
	@JsonSerialize(using=LocalDateSerializer.class)
	@JsonDeserialize(using=LocalDateDeserializer.class)
	private LocalDate regDate;
	// one to many bi dir asso between entities
@JsonManagedReference
	private List<BankAccount> accts = new ArrayList<>();
	// one to many uni dir between Entity n value type
	
	private List<Card> cards = new ArrayList<>();

	public Vendor() {
		System.out.println("in vendor constr");
	}

	public Vendor(String name, String email, String password, String city, String phoneNo, String role,
			double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phoneNo = phoneNo;
		this.role = role;
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

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
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

	@Column(length = 10, unique = true)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(length = 20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Column(name = "reg_dt")
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@OneToMany(mappedBy = "myVendor", cascade = CascadeType.ALL)
	public List<BankAccount> getAccts() {
		return accts;
	}

	public void setAccts(List<BankAccount> accts) {
		this.accts = accts;
	}

	@ElementCollection
	@CollectionTable(name = "vendor_cards", joinColumns = @JoinColumn(name = "v_id"))
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	// bi dir ---convenience methods
	public void addAccount(BankAccount a) {
		accts.add(a);
		a.setMyVendor(this);
	}

	public void removeAccount(BankAccount a) {
		accts.remove(a);
		a.setMyVendor(null);
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
				+ ", phoneNo=" + phoneNo + ", role=" + role + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
