package dao;

import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	List<Candidate> getCandidateList() throws Exception;
	String incVotes(int candidateId) throws Exception;
}
