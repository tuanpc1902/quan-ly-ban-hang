package com.tuanpc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tuanpc.entity.*;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findCategoryById(String cid);

	List<Product> findByCategoryId(String cid);


}



