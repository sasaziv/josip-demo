package com.aplos.josipdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoriesController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRespository productRespository;

	@GetMapping(value = "/categories")
	public ModelAndView categories(Model model) {
		ModelAndView mv = new ModelAndView("categories");
		List<Category> categoryList = categoryRepository.findAll();
		for (Category category : categoryList) {
			category.setNumberOfProducts(categoryRepository.countProductsInCategory(category.getId()));
		}
		mv.addObject("categories", categoryList);
		return mv;
	}

	@GetMapping(value = "/categories/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		categoryRepository.deleteById(id);
		return "redirect:/categories";
	}

	@GetMapping("/addcategory")
	public ModelAndView addCategory() {
		ModelAndView mv = new ModelAndView("addCategory");
		return mv;
	}

	@PostMapping(path = "/addcategory")
	public ModelAndView addCategory(@RequestParam String newCategoryName) {
		ModelAndView mv = new ModelAndView("addCategoryConfirmation");
		Category newCategory = new Category();
		newCategory.setName(newCategoryName);
		Category savedCategory = categoryRepository.save(newCategory);
		mv.addObject("savedCategory", savedCategory);
		return mv;
	}

	@GetMapping(path = "/categories/{id}")
	public String category(@PathVariable("id") Integer id, Model model) {
		java.util.Optional<Category> category = categoryRepository.findById(id);
		model.addAttribute("category", category.get());
		return "category";
	}

	@PostMapping(path = "/categories/{id}")
	public String editCategory(@PathVariable("id") Integer id, @RequestParam String editCategoryName, Model model) {
		Category category = new Category();
		category.setId(id);
		category.setName(editCategoryName);
		categoryRepository.save(category);
		category(id, model);
		return "redirect:/categories";
	}

	@GetMapping(value = "/addcategoryform")
	public ModelAndView viewNewCategoryForm(Map<String, Object> model) {
		ModelAndView mv = new ModelAndView("addCategoryForm");
		Category addCategory = new Category();
		mv.addObject("addCategory", addCategory);
		return mv;
	}

	@PostMapping(value = "/addcategoryform")
	public ModelAndView addNewCategoryForm(@ModelAttribute("addCategory") Category category) {
		ModelAndView mv = new ModelAndView("addCategoryConfirmation");
		mv.addObject("savedCategory", category);
		categoryRepository.save(category);
		return mv;
	}

	@GetMapping(path = "/{categoryname}/products")
	public ModelAndView categoryProducts(@RequestParam Integer categoryId, ModelAndView mv) {
		List<Category> categories = categoryRepository.findAll();
		Category category = null;
		for (Category cat : categories) {
			if (categoryId == cat.getId()) {
				category = cat;
				break;
			} else {
				category = new Category();
			}
		}
		System.out.println(categoryId);
		List<Product> products = productRespository.findByCategory(category);
		mv.addObject("products", products);
		mv.setViewName("productsFromCategory");
		return mv;
	}
}