package com.app.service;

import com.app.pojos.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao dao;

	@Transactional(readOnly = false)
	@Override
	public Account createAccount(Account a) {
		// TODO Auto-generated method stub
		return dao.createAccount(a);
	}

	@Transactional(readOnly = true)
	@Override
	public Account getAccount(int id, int bid) {
		// TODO Auto-generated method stub
		return dao.getAccount(new AccountPK(id, bid));
	}

	@Override
	@Transactional(readOnly = false)
	public String updateAccount(Account a) {
		// TODO Auto-generated method stub
		return dao.updateAccount(a);
	}

}
