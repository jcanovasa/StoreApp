package com.javaschool.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaschool.project.models.User;
import com.javaschool.project.repository.UserRepository;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users")
	public List<User> listAllUsers() {
		System.out.println("hola");
		return repository.findAll();
	}
}
