package com.tuanpc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanpc.dao.RoleDAO;
import com.tuanpc.entity.Role;
import com.tuanpc.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired 
	RoleDAO dao;
	
	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

}
