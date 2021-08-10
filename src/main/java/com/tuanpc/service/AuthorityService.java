package com.tuanpc.service;

import java.util.List;

import com.tuanpc.entity.Authority;

public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority authority);

	void delete(Integer id);

}
