package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	// dependency
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public User authenticateUser(String email, String pwd) {
		String jpql = "select u from User u where u.email = :em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pwd)
				.getSingleResult();
	}

}
