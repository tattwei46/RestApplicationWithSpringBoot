package com.davidcheah.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidcheah.application.services.UserService;
import com.davidcheah.application.exception.UserNotFoundException;
import com.davidcheah.application.model.User;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	//http://localhost:8080/users
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = service.getAllUsers();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = service.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return service.getUser(id);
	}
		
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User newUser = service.add(user);
		return newUser;
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User removedUser = service.delete(id);
		return removedUser;
	}
}
