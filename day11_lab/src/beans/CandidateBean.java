package beans;

import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Analysis;
import pojos.Candidate;

public class CandidateBean {
	//conversational state of clnt 
	private int cId;
	private CandidateDaoImpl dao;
	public CandidateBean() {
		System.out.println("in candidate bean constr");
	   dao=new CandidateDaoImpl(); 
	}
	
	public void setcId(int cId) {
		this.cId = cId;
	}

	//B.L method for returning candidate list
	public List<Candidate> listCandidates()
	{
		return dao.getCandidateList();
	}
	//B.L method for inc votes
	public String updateVotes()
	{
		System.out.println("B.L cid "+cId);
		return dao.incrementVotes(cId);
	}
	//for admin login
	// get votes stats
	public List<Analysis> votesAnalysis()  {
		return dao.votesAnalysis();
	}
	//top 2 candidates with max votes
	public List<Candidate> topNAnalysis()  {
		return dao.maxVotesCandidates();
	}


}
