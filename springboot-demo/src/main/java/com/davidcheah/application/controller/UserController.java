package com.davidcheah.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcheah.application.services.UserService;
import com.davidcheah.application.model.User;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		List<User> users = service.retrieveUsers();
		return users;
	}
}
