package pojos;

import java.util.Date;

//JPA Specs
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity // class level - Mandatory
@Table(name = "dac_users") // optional but useful
public class User {
	// ID(Primary key) property must be serializable
	private Integer userId; // ID
	private String name, email, password, role, confirmPassword;
	private double regAmount;
	private Date regDate;
	private UserType userType;
	private byte[] image;

	// supply def CTOR - MUST

	public User() {
		System.out.println("in User CTOR");
	}

	public User(String name, String email, String password, String role, String confirmPassword, double regAmount,
			Date regDate, UserType userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userType = userType;
	}

	// generate all getters and setters - MUST
	@Id // mandatory - PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "user_type")
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Lob	//BLOB type column
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount + ", regDate=" + regDate
				+ ", userType=" + userType + "]";
	}

}
