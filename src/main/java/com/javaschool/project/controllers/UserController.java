package com.javaschool.project.controllers;

import java.util.List;

//import com.javaschool.project.exceptions.ResourceNotFoundException;
import com.javaschool.project.exceptions.ResourceNotFoundException;
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



	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found)"));
		return ResponseEntity.ok(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(("User with id " + id + " does not found")));
		user.setName(userDetails.getName());
		user.setSurname(userDetails.getSurname());
		user.setEmail(userDetails.getEmail());
		user.setBirth(userDetails.getBirth());

		User updatedUser = repository.save(user);
		return ResponseEntity.ok(user);
	}
}
