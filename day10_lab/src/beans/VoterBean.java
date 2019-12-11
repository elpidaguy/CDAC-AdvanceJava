package beans;

import dao.VotersDaoImpl;
import pojos.Voters;

public class VoterBean {
	
	int id;
	String email,password;
	boolean status;
	VotersDaoImpl vdi;
	Voters voterObj;
	
	
	public Voters getVoterObj() {
		return voterObj;
	}

	public void setVoterObj(Voters voterObj) {
		this.voterObj = voterObj;
	}

	String message;
	
	public VoterBean() throws Exception {
		vdi = new VotersDaoImpl();
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
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public VotersDaoImpl getVdi() {
		return vdi;
	}
	
	public String validateVoter() throws Exception {
		voterObj = vdi.authenticateVoter(email, password);
		if (voterObj == null) {
			message = "Invalid Login ,pls retry....";
			return "index";
		}
		message = "Login successful";
		if(voterObj.isStatus())
		{
			return "status";
		}
		return "candidateList";

	}
	
	public void UpdateStatus() throws Exception {
//		System.out.println(voter.getId());
		vdi.UpdateStatus(voterObj.getId());
	}
	
	public String registerVoter() throws Exception {
		Integer i = vdi.registerVoter(email, password);
		if(i == 0)
		{
			message = "Something went Wrong!! Try again";
			return "register";
		}
		
		return "index";
		
	}

}
