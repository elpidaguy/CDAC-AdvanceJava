package com.app.service;

import com.app.pojos.*;

public interface AccountService {
	Account createAccount(Account a);
	Account getAccount(int acctId,int brId);
	String updateAccount(Account a);
}
