package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	User authenticateUser(String email,String pwd);

}
