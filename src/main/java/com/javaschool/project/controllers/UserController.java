package com.javaschool.project.controllers;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaschool.project.models.User;
import com.javaschool.project.repository.UserRepository;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	//Con este método listo a todos los usuarios
	@GetMapping("/users")
	public List<User> listAllUsers() {
		return repository.findAll();
	}

	//Con este método guardo un nuevo usuario y mando el objeto user como json
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}


	}
