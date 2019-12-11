package beans;

import dao.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
	private String email, password;
	private VoterDaoImpl dao;
	// results
	private Voter details;
	private String message,status;

	// constr
	public VoterBean() {
		System.out.println("voter bean constr");
		dao = new VoterDaoImpl();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Voter getDetails() {
		return details;
	}

	public String getMessage() {
		return message;
	}
	

	public String getStatus() {
		return status;
	}

	// B.L method for voter authentication
	public String validateVoter() {
		System.out.println("validate voter " + email + " " + password);
		try {
			details = dao.authenticateVoter(email, password);
			//login successful
			status = details.getRole() +" , "+details.getEmail()+ ",  login Successful  ";
			//chk the role 
			if (details.getRole().equals("voter")) {
				if (details.getStatus()) // has alrdy voted
				{
					message = "You have already voted!!!!";
					return "status";//navigate to status page directly
				}
				message = "You are voting now....";
				return "candidate_list";//navigate to candidate list page
			}
			// admin login --show analysis
			return "analysis";
			
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// login failed
			message="Invalid login";
			return "login";
		}
	}
   //B.L method to update voting status
	public String updateStatus()
	{
		message=dao.updateVotingStatus(details);
		return "";
	}
}
