package com.javaschool.project.controllers;

import java.util.List;

import com.javaschool.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaschool.project.exceptions.ResourceNotFoundException;
import com.javaschool.project.models.Product;
import com.javaschool.project.repository.ProductRepository;
@RestController
@RequestMapping("/api/products/")
@CrossOrigin(origins = "http://localhost:4200")
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

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = repository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		return ResponseEntity.ok(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = repository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
		product.setNameItem(productDetails.getNameItem());
		product.setPrice(productDetails.getPrice());
		product.setBrand(productDetails.getBrand());
		product.setCategory(productDetails.getCategory());
		product.setColor(productDetails.getColor());
		product.setId(productDetails.getId());
		product.setImgURL(productDetails.getImgURL());
		product.setVolume(productDetails.getVolume());
		product.setStock(productDetails.getStock());
		product.setWeight(productDetails.getWeight());

		Product updatedProduct = repository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
}
