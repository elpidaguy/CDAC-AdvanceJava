package dao;

import static utils.HibernateUtils.getSf;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	@Override
	public String incVotes(int candidateId) throws Exception {
		String msg = "Voting Failed";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		String jpql = "select c from Candidate c where c.id=:cid";
		try {
			
			Candidate c = hs.createQuery(jpql, Candidate.class).setParameter("cid", candidateId).getSingleResult();
			c.setVotes(c.getVotes()+1);
			tx.commit();
			msg = "Voted Successfully!";
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public List<Candidate> getCandidateList() throws Exception {

		List<Candidate> l1 = new ArrayList<>();
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		String jpql = "select c from Candidate c";
		try {
			
			l1 = hs.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}
}
