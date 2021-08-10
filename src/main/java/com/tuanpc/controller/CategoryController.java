package com.tuanpc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuanpc.dao.CategoryDAO;
import com.tuanpc.entity.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO dao; 
	
	// hàm 1
	@RequestMapping("/category")
	public String index(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "/layout/category";
	}
	
	// hàm 2
	@RequestMapping("/category/edit")
	public String edit(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "category/edit";
	}
	
	@RequestMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Category item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "category/edit";
	}

	// hàm 3
	@RequestMapping("/category/create")
	public String create(Category item) {
		dao.save(item);
		return "redirect:/category";
	}

	// hàm 4
	@RequestMapping("/category/update")
	public String update(Category item) {
		dao.save(item);
//		return "redirect:/category/edit/" + item.getId();
		return "redirect:/category";
	}

	// hàm 5
	@RequestMapping("/category/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/category";
	}
	

}

