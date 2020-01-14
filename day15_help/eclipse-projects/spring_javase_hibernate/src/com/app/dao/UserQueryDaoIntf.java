package com.app.dao;

import java.util.List;

import pojos.User;

public interface UserQueryDaoIntf {

	List<User> getUsersByCriteria();
	List<User> getUsersByNamedQuery();

}