package com.javaschool.project.controllers;

import java.util.List;

import com.javaschool.project.exceptions.ResourceNotFoundException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaschool.project.models.User;
import com.javaschool.project.repository.UserRepository;

//La primera anotación me sirve para decirle a Spring que esta clase es un controlador de REST, es decir, que
//va a manejar solicitudes HTTP devolviendo las respuestas como JSON o XML. La segunda anotación sirve para
//asociar la URL de /api/users de forma que todas las solicitudes que se envíen a dicha ruta serán manejadas
//por los métodos de éste controlador. La última anotación es para habilitar el acceso del CORS en un controlador
//de l REST.
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	//Esta anotación sirve para inyectar una instancia del UserRepository en la clase UserController.
	//No es obligatoria, ya que existen alternativas como por ejemplo inyectar las dependencias explícitamente
	//en el constructor o en un setter.
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
		repository.deleteById(id);
		JSONObject response = new JSONObject();
		response.put("msg", "The user will be deleted.");
		System.out.println(response.get("msg"));
		return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
	}
}
