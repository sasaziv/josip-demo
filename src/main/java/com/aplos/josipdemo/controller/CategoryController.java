package com.aplos.josipdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping(value = "/kategorije")
	public List<Category> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		// int size = categories.get(0).getProducts().size();
		return categories;
	}

	@GetMapping(value = "/kategorije/{id}")
	public Optional<Category> getCategory(@PathVariable("id") Integer id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category;
	}

}
