package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = service.createUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		User saveUser = service.updateUser(id, user);
		return new ResponseEntity<User>(saveUser, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<User>> getAllUser() {
		Iterable<User> userList = service.getAllUser();
		return new ResponseEntity<Iterable<User>>(userList, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getById(@PathVariable("id") int id) {
		User user = service.getById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable("id") int id) {
		service.deleteUser(id);
	}

}
