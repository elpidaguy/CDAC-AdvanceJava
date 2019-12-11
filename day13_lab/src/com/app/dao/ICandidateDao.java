package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface ICandidateDao {
	List<Candidate> getCandidateList();

	String incrementVotes(int candidateId);

	// party wise voting analysis
	List<Analysis> votesAnalysis();

	// top 2 candidates securing max votes.
	List<Candidate> maxVotesCandidates();

}
