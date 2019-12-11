package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.*;

import com.app.pojos.Voter;

//handled by spring 
@Repository
@Transactional	//for spring without service layer
public class VoterDaoImpl implements IVoterDao {

	//dependency
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Voter authenticateVoter(String em, String pass) {
		String jpql = "select v from Voter v where v.email=:ema and v.password=:passw";		
		return sf.getCurrentSession().createQuery(jpql, Voter.class).setParameter("ema",em ).setParameter("passw", pass).getSingleResult();
	}

	@Override
	public String updateVotingStatus(Voter v) {
		//v - detached pojo
		v.setStatus(true);
		sf.getCurrentSession().update(v); //copies detached pojo reference to L1 cache
		return "Voting Status Updated Successfully";
	}

}
