package com.app.dao;

import com.app.pojos.*;


public interface AccountDao {
	Account createAccount(Account a);
	Account getAccount(AccountPK pk);
	String updateAccount(Account a);
}
