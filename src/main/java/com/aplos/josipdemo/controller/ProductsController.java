package com.aplos.josipdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

	@Autowired
	ProductRespository productRespository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping(value = "/products")
	public ModelAndView viewProducts() {
		List<Product> productList = productRespository.findAll();
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("products", productList);
		return mv;
	}

	@GetMapping({ "/product", "/product/{id}" })
	public ModelAndView viewProduct(@PathVariable(required = false) Integer id) {
		ModelAndView mv = new ModelAndView("product");
		Product product = new Product();
		if (id != null) {
			product = productRespository.findById(id).get();
		}
		List<Category> categoryList = categoryRepository.findAll();
		mv.addObject(product);
		mv.addObject(categoryList);
		return mv;
	}

	@PostMapping({ "/product", "/product/{id}" })
	public ModelAndView addProduct(@ModelAttribute("product") Product product) {
		ModelAndView mv = new ModelAndView("redirect:/products");
		Product pr = product;
		productRespository.save(pr);
		return mv;
	}

	@GetMapping("products/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") Integer id) {
		productRespository.deleteById(id);
		ModelAndView mv = new ModelAndView("redirect:/products");
		return mv;
	}
}
