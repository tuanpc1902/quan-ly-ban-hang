package com.tuanpc.service;

import java.util.List;

import com.tuanpc.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	List<Product> findCategoryById(String string);
	
}

