package com.app.dao;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.*;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Account createAccount(Account a) {
		// TODO Auto-generated method stub
		System.out.println("Acct saved with "+sf.getCurrentSession().save(a));
		return a;
	}

	@Override
	public Account getAccount(AccountPK pk) {
		// TODO Auto-generated method stub
		return (Account)sf.getCurrentSession().get(Account.class,pk/*,LockOptions.READ*/);
	}

	@Override
	public String updateAccount(Account a) {
		String sts="updated successfully";
		sf.getCurrentSession().update(a);
		return sts;
	}
	

}
