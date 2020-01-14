package com.app.dao;

import pojos.User;

public interface UserDaoIntf {
	User validateUser(String em,String pass);
}
