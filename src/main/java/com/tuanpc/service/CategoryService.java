package com.tuanpc.service;

import java.util.List;

import com.tuanpc.entity.Category;

public interface CategoryService {

	List<Category> findAll();

	Category create(Category category);

	Category findById(String id);

	Category update(Category category);

	void delete(String id);

}
