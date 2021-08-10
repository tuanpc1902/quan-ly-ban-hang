package com.tuanpc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanpc.dao.CategoryDAO;
import com.tuanpc.entity.Category;
import com.tuanpc.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired CategoryDAO categoryDAO;
	
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	@Override
	public Category findById(String id) {
		return categoryDAO.findById(id).get();
	}

//	@Override
//	public List<Category> findByCategoryId(String cid) {
//		return categoryDAO.findByCategoryId(cid);
//	}

	@Override
	public Category create(Category category) {
		return categoryDAO.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryDAO.save(category);
	}

	@Override
	public void delete(String id) {
		categoryDAO.deleteById(id);
	}

//	@Override
//	public List<Category> findCategoryById(String cid) {
//		return categoryDAO.findCategoryById(cid);
//	}
}
