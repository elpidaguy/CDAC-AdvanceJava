package dao;

import java.util.List;

import pojos.Candidate;
import pojos.Voters;

public interface IVotingDao {
	
	Voters authenticateVoter(String em,String pass) throws Exception;
	List<Candidate> getCandidateList() throws Exception;
	String incVotesUpdateStatus(int candidateId,int voterId) throws Exception;


}
