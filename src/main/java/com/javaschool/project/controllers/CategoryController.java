package com.javaschool.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaschool.project.models.Category;
import com.javaschool.project.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping("/categories")
	public List<Category> listAllCategories() {
		return repository.findAll();
	}
}
