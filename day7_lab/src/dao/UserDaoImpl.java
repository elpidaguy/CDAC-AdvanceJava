package dao;

import static utils.HibernateUtils.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User u) {
		//get session from session factory
		Session hs = getSf().openSession();
		//begin transaction
		Transaction tx = hs.beginTransaction();
		
		try {
			hs.save(u);
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			//rethrow the exception to the caller
			throw e;
		}
		finally {
			//close session - return pooled out DB Connection
			hs.close();
		}		
		return "User Registered Successfully!" + u.getUserId();
	}

}
