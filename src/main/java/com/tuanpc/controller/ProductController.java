package com.tuanpc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuanpc.entity.Product;
import com.tuanpc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list = productService.findCategoryById(cid.get());
			model.addAttribute("items", list);
		}
		else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		}
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}

//	@RequestMapping("/product/sort")
//	public String sort(Model model, 
//		@RequestParam("field") Optional<String> field) {
//		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
//		model.addAttribute("field", field.orElse("price").toUpperCase());
//		List<Product> items = dao.findAll(sort);
//		model.addAttribute("page", items);
//		return "/product/index";
//	}

	
//	@RequestMapping("/student/index")
//	public String index(Model model) {
//		Student student = new Student("", "", 0.0, true, "VN");
//		model.addAttribute("form", student);
//		StudentMap map = dao.findAll();
//		model.addAttribute("items", map);
//		
//		return"student/index";
//	}
	
//	@RequestMapping("/product")
//	public String paginate(Model model,
//		@RequestParam("p") Optional<Integer> p ) {
//		Pageable pageable = PageRequest.of(p.orElse(0), 35);
//		Page<Product> page = dao.findAll(pageable);
//		model.addAttribute("page", page);
//		return "product/index";
//	}
	
	
//	@RequestMapping("/product")
//	public String paginate(Model model,
//		@RequestParam("p") Optional<Integer> p ) {
//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
//		Page<Product> page = dao.findAll(pageable);
//		model.addAttribute("page", page);
//		return "product/index";
//	}

//	@Autowired
//	SessionService session;
//
//	@RequestMapping("/product/search")
//	public String searchAndPage(Model model, 
//			@RequestParam("keywords") Optional<String> kw,
//			@RequestParam("p") Optional<Integer> p) {
//		String kwords = kw.orElse(session.get("keywords", ""));
//		session.set("keywords", kwords);
//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
//		//Page<Product> page = dao.findByKeywords("%"+kwords+"%", pageable); //lab6.3
//		Page<Product> page = dao.findAllByNameLike("%"+kwords+"%", pageable); //lab6.5
//		model.addAttribute("page", page);
//		return "product/index";
//	}
	
	
//	@GetMapping("/product/create")
//	public String doGetUpdate(Model model, @ModelAttribute("item") Product item) {
////		model.addAttribute("item", new Product());
//		return "product/create";
//	}
//	
//	@PostMapping("/product/create")
//	public String doPostCreate(Product item) {
//		dao.save(item);
//		return "redirect:/product";
//	}
//	
//	// hàm 4
//	
//	@GetMapping("/product/edit/{id}")
//	public String edit(Model model, @PathVariable("id") Integer id) {
//		Product item = dao.findById(id).get();
//		model.addAttribute("item", item);
//		List<Product> items = dao.findAll();
//		model.addAttribute("items", items);
//		return "product/edit";
//	}
//	
//	@PostMapping("/product/update")
//	public String update(Product item) {
//		dao.save(item);
////		return "redirect:/product/edit/" + item.getId();
//		return "redirect:/product";
//	}
//	
//	// hàm 5
//	@RequestMapping("/product/delete/{id}")
//	public String delete(@PathVariable("id") Integer id) {
//		dao.deleteById(id);
//		return "redirect:/product";
//	}
	

//	@PostMapping("/upload")
//	public String upload(@RequestPart("photo_file") MultipartFile) {
//		
//		return return "redirect:/product";
//	}
	
	
//	@PostMapping("/product/create")
//	public String DoPostUpdate(Model model, @ModelAttribute("item") Product item) {
//		dao.save(item); 
//		System.out.println("here2!!");
//		System.out.println(item.getId());
//		System.out.println(item.getName());
//		System.out.println(item.getImage());
//		System.out.println(item.getAvailable());
//		System.out.println(item.getCategory());
//		
//		return "redirect:/product";
//	}
	
}

