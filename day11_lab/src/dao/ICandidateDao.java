package dao;

import java.util.List;

import pojos.Analysis;
import pojos.Candidate;

public interface ICandidateDao {
	List<Candidate> getCandidateList();

	String incrementVotes(int candidateId);

	// party wise voting analysis
	List<Analysis> votesAnalysis();

	// top 2 candidates securing max votes.
	List<Candidate> maxVotesCandidates();

}
