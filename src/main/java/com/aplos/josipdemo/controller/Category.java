package com.aplos.josipdemo.controller;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
//@NamedNativeQuery(name = "Category.getNumberOfProduct", query = "select *, id from product", resultClass = Category.class)
public class Category {

	@Transient
	@Autowired
	CategoryRepository categoryRepository;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category")
	Set<Product> products = new HashSet<Product>();

	@Transient
	private Integer numberOfProducts;

	@PreRemove
	private void preRemove() {
		for (Product product : products) {
			product.setCategory(null);
		}
		// children.forEach( child -> child.setParent(null));
	}

	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
		this.numberOfProducts = categoryRepository.countProductsInCategory(id);
	}

	public Category() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(Integer numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

}
