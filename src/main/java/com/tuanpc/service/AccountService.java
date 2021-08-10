package com.tuanpc.service;

import java.util.List;

import com.tuanpc.entity.Account;

public interface AccountService {
	Account findById(String name);

	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account account);

	Account update(Account account);

	void delete(String id);
}
