package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.BankAccount;
import com.app.pojos.User;

@Repository
@Transactional
public class BankAccountDaoImpl implements IBankAccountDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public String createNewAccount(User u, BankAccount a) {
		u.addAccount(a);//u --detached , a--transient
		sf.getCurrentSession().update(u);//u -- persistent
		return "Created A/C for Vendor "+u.getName();
	}

	@Override
	public String closeAccount(int userId, int acId) {
		Session hs=sf.getCurrentSession();
		User u=hs.get(User.class, userId);//u --persistent
		BankAccount a=hs.get(BankAccount.class, acId);//a --persistent
		u.removeAccount(a);
		return "Closed A/C ID "+acId+" for Vendor "+u.getName();
	}
	

}
