package com.tuanpc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanpc.dao.AccountDAO;
import com.tuanpc.dao.AuthorityDAO;
import com.tuanpc.entity.Account;
import com.tuanpc.entity.Authority;
import com.tuanpc.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired AuthorityDAO authorityDAO;
	@Autowired AccountDAO accountDAO;
	
	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	@Override
	public Authority create(Authority authority) {
		return authorityDAO.save(authority);
	}

	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}
	 
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountDAO.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}
}
