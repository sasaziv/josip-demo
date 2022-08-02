package com.aplos.josipdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductRespository productRespository;

	@GetMapping("/nesto")
	public List<Product> index() {
		return productRespository.findAll();
	}
}
