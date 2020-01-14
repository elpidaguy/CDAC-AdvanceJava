package pojos;

import java.util.Date;
import javax.persistence.*;//JPA

@Entity // mandatory
@Table(name = "dac_custs")
@NamedQueries(@NamedQuery(name = "all_users",
query = "select u from User u order by u.regAmount"))
public class User {

	private Integer userId;
	private String name, email, pass, role;
	private double regAmount;
	private Date regDate;

	public User() {
		System.out.println("in cust def cnstr");
	}

	public User(int userId, String name, String email, String pass, String role, double regAmount, Date regDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	public User(String name, String email, String pass, String role, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id // mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY) // suited for MySQL
	@Column(name = "cust_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(length = 20)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(columnDefinition = "double(6,1)", name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_dt")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", role=" + role + ", regAmount="
				+ regAmount + ", regDate=" + regDate + "]";
	}

}
