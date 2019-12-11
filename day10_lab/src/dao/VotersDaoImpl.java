package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Voters;

public class VotersDaoImpl implements IVotingDao {

	@Override
	public Voters authenticateVoter(String em, String pass) throws Exception {
		Voters v = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		
		String jpql = "select v from Voters v where v.email=:email and v.password=:password";
		try {
			
			v = hs.createQuery(jpql, Voters.class).setParameter("email", em).setParameter("password", pass).getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return v;

	}
	
	@Override
	public String UpdateStatus(int voterId) throws Exception {
		String msg = "Voting Failed";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		String jpql = "select v from Voters v where v.id=:vid";
		try {
			Voters v = hs.createQuery(jpql, Voters.class).setParameter("vid", voterId).getSingleResult();
			v.setStatus(true);
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
	public Integer registerVoter(String em, String pass) throws Exception {
		
		int i=0;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		
		try {
			i = (Integer) hs.save(new Voters(em,pass));
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return i;
	}

}
