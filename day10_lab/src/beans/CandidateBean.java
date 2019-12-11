package beans;

import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {
	
	private CandidateDaoImpl cdi;
	private int cid;
	public CandidateBean() throws Exception {
		cdi = new CandidateDaoImpl();
	}
	
	public List<Candidate> getCandidateList() throws Exception {
	
		return cdi.getCandidateList();
		
	}
	
	public void setCid(int cid) {
		System.out.println("Inside set cid"+ cid);
		this.cid = cid;
	}

	public void incVotes() throws Exception {
		cdi.incVotes(cid);
	}

}
