package dao;

import pojos.Voter;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class VoterDaoImpl implements IVoterDao {

	@Override
	public Voter authenticateVoter(String em1, String pass1) {
		String jpql = "select v from Voter v where v.email=:em and v.pass=:pa";
		Voter v = null;
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			v = hs.createQuery(jpql, Voter.class).setParameter("em", em1).setParameter("pa", pass1).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return v;
	}

	@Override
	public String updateVotingStatus(Voter v) {
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			//re attach detached POJO with L1 cache
			//detached--->persistent (update)
			//v --detached
			hs.update(v);//v --persistent
			v.setStatus(true);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Voting done....";
	}

}
