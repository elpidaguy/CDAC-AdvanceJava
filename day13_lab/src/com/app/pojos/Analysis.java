package com.app.pojos;

public class Analysis {
	private String politicalParty;
	private long votes;

	public Analysis() {
		System.out.println("analysis constr");
	}

	public Analysis(String politicalParty, long votes) {
		super();
		this.politicalParty = politicalParty;
		this.votes = votes;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}

	
	
	

}
