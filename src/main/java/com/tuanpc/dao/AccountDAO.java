package com.tuanpc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tuanpc.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{
	
	@Query("select DISTINCT ar.account from Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();
}
