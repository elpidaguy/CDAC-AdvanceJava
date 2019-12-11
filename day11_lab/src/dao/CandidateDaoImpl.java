package dao;

import static utils.HibernateUtils.getSf;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Analysis;
import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	@Override
	public List<Candidate> getCandidateList() {
		String jpql = "select c from Candidate c";
		List<Candidate> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public String incrementVotes(int candidateId) {
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			Candidate c = hs.get(Candidate.class, candidateId);
			// c -- PERSISTENT
			c.setVotes(c.getVotes() + 1);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Votes updated";
	}

	@Override
	public List<Analysis> votesAnalysis() {
		List<Analysis> l1 = null;
		/*
		 * select party,sum(votes) from candidates group by party
		 */
		String jpql = "select new pojos.Analysis(c.party,sum(c.votes)) from Candidate c group by party";
		// HS
		Session hs = getSf().getCurrentSession();
		// Tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Analysis.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public List<Candidate> maxVotesCandidates() {
		List<Candidate> l1 = null;
		String jpql = "select c from Candidate c order by c.votes desc";
		// HS
		Session hs = getSf().getCurrentSession();
		// Tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Candidate.class).
					setMaxResults(2).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println("top 2 " + l1);
		return l1;
	}

}
