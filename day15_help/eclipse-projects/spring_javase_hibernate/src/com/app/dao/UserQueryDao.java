package com.app.dao;

import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojos.*;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

@Repository
@Transactional
public class UserQueryDao implements UserQueryDaoIntf {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> getUsersByCriteria() {
		Session hs = sf.getCurrentSession();
		CriteriaQuery<User> query =
				hs.getCriteriaBuilder().createQuery(User.class);
		query.from(User.class);
		return hs.createQuery(query).getResultList();

	}

	@Override
	public List<User> getUsersByNamedQuery() {

		return sf.getCurrentSession().
				createNamedQuery("all_users", User.class).getResultList();
	}

}
