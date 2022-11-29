package com.javaschool.project.controllers;

import java.util.List;

//import com.javaschool.project.exceptions.ResourceNotFoundException;
import com.javaschool.project.exceptions.ResourceNotFoundException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaschool.project.models.User;
import com.javaschool.project.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	//Con este método listo a todos los usuarios
	@GetMapping("")
	public List<User> listAllUsers() {
		return repository.findAll();
	}

	//Con este método guardo un nuevo usuario y mando el objeto user como json
	@PostMapping("")
	public User saveUser(@RequestBody User user) {
		return repository.save(user);
	}

	//Con este selecciono un usuario en concreto
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found)"));
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
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

	@DeleteMapping("/{id}")
	public ResponseEntity<JSONObject> deleteUser(@PathVariable Long id) {
		System.out.println("hola3-------------------------------------------------------------------");
		repository.deleteById(id);
		JSONObject respuesta = new JSONObject();
		respuesta.put("msg", "The user will be deleted.");
		System.out.println(respuesta.get("msg"));
		return new ResponseEntity<JSONObject>(respuesta, HttpStatus.OK);
	}
}
