package pojos;

import javax.persistence.*;

@Entity
@Table(name = "voters")
public class Voters extends AbstractEntity {
	String email, password;
	boolean status;
//	UserType role;
//
//
//	public UserType getRole() {
//		return role;
//	}
//
//	public void setRole(UserType role) {
//		this.role = role;
//	}

	public Voters()
	{
		System.out.println("Voters CTOR called");
	}
	
	public Voters(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.status = false;
	}

//	public Voters(int id, String email, boolean status) {
//		super();
//		this.email = email;
//		this.status = status;
//	}

	@Override
	public String toString() {
		return "Voters [email=" + email + ", password=" + password + ", status=" + status + "]";
	}

	@Column(length = 30,unique = true)
	public String getEmail() {
		return email;
	}

	@Column(length=15)
	public String getPassword() {
		return password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
