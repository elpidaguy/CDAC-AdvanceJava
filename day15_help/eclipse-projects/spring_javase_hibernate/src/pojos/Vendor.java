package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // mandatory
@Table(name = "dac_hib_vendors")
public class Vendor {
	private Integer id;
	private String name, email, city, phoneNo;
	private double regAmount;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date regDate;
	// one-to-many
	private List<Vehicle> vehicles = new ArrayList<>();
	// one-to-one
	private AdharCard card;
	// many-to-many
	private List<Company> companies = new ArrayList<>();

	public Vendor() {
		System.out.println("in vendor constr");
	}

	public Vendor(String name, String email, String city, String phoneNo, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.phoneNo = phoneNo;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id // mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
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

	@Column(length = 10, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 10)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ph_no", length = 10)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "reg_amt", columnDefinition = "double(6,1)")
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "myVendor")
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "myVendor")
	public AdharCard getCard() {
		return card;
	}

	public void setCard(AdharCard card) {
		this.card = card;

	}

	@ManyToMany(mappedBy = "vendors")
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	// convenience method to add vehicle
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
		v.setMyVendor(this);
	}

	// convenience method to link adhar card number
	public void linkAdhar(AdharCard c) {
		setCard(c);
		c.setMyVendor(this);
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", phoneNo=" + phoneNo
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
