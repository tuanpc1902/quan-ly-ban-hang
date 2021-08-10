package com.tuanpc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuanpc.dao.CategoryDAO;
import com.tuanpc.dao.ProductDAO;
import com.tuanpc.entity.Product;
import com.tuanpc.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductDAO dao;

	CategoryDAO
	cateDao;
	
	@Autowired
	ProductService productService;

	@RequestMapping({"/", "/index"})
	public String list(Model model) {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		return "product/list";
	}
		@RequestMapping({"/admin", "/admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = dao.findById(id).get();
		model.addAttribute("items", item);
		List<Product> items = dao.findAll();
		model.addAttribute("items", items);
		return "detail";
	}
	
}
