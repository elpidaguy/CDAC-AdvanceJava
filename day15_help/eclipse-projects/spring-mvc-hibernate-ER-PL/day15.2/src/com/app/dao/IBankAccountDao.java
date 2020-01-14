package com.app.dao;

import com.app.pojos.BankAccount;
import com.app.pojos.User;

public interface IBankAccountDao {
	String createNewAccount(User u, BankAccount a);

	String closeAccount(int userId,int acId);

}
