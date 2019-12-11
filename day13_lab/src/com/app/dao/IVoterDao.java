package com.app.dao;

import com.app.pojos.Voter;

public interface IVoterDao {
	Voter authenticateVoter(String em,String pass);
	//i/p detached voter ref --kept in Java bean (Http session)
    String updateVotingStatus(Voter v);
}
