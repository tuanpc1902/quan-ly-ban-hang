package com.tuanpc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuanpc.entity.Category;
import com.tuanpc.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired 
	CategoryService categporySerivce;
	
	@GetMapping()
	public List<Category> getAll() {
		return categporySerivce.findAll();
	}
	
	
	@GetMapping("{id}")
	public Category getOne(@PathVariable("id") String id) {
		return categporySerivce.findById(id);
	}
	
	@PostMapping()
	public Category create(@RequestBody Category category) {
		return categporySerivce.create(category);
	}
	@PutMapping("{id}")
	public Category update(@PathVariable("id") String id,@RequestBody Category category) {
		return categporySerivce.update(category);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		categporySerivce.delete(id);
	}
}
