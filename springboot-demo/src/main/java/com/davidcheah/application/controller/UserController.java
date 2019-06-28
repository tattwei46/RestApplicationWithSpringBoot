package com.davidcheah.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.davidcheah.application.services.UserService;
import com.davidcheah.application.model.User;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		List<User> users = service.getAllUsers();
		return users;
	}
	
	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable int id) {
		return service.getUser(id);
	}
}
