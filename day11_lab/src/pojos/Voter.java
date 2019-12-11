package pojos;
import javax.persistence.*;
@Entity
@Table(name="voters")
public class Voter {
	private Integer id;
	private String email,pass;
	private boolean status;
	private String role;
	public Voter() {
		System.out.println("in voter constr");
	}
	public Voter(Integer id, String email, String pass, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Column(length = 20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", email=" + email + ", status=" + status + "]";
	}
	
	

}
