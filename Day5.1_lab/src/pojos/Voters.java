package pojos;

public class Voters {
int id;
String email,password;
boolean status;
public Voters(int id, String email, String password, boolean status) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.status = status;
}



public Voters(int id, String email, boolean status) {
	super();
	this.id = id;
	this.email = email;
	this.status = status;
}



@Override
public String toString() {
	return "Voters [id=" + id + ", email=" + email + ", password=" + password + ", status=" + status + "]";
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
public boolean isStatus() {
	System.out.println("inside is status"+ status);
	return status;
}


}
