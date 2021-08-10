package com.tuanpc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanpc.dao.AccountDAO;
import com.tuanpc.entity.Account;
import com.tuanpc.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
@Autowired AccountDAO accountDAO;
	
	@Override
	public Account findById(String username) {
		return accountDAO.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		return accountDAO.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}
	
	@Override
	public Account create(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public Account update(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public void delete(String id) {
		accountDAO.deleteById(id);
	}
}
