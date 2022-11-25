package com.javaschool.project.controllers;

import java.util.List;

import com.javaschool.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaschool.project.models.Product;
import com.javaschool.project.repository.ProductRepository;
@RestController
@RequestMapping("/api/products/")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/products")
	public List<Product> listAllProducts(){
		return repository.findAll();
	}

	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return repository.save(product);
	}
}
