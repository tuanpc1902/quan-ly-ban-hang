package com.tuanpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuanpc.entity.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

}
