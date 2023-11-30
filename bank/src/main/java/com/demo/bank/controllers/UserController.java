package com.demo.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.dto.LoginRequest;
import com.demo.bank.dto.UserDto;
import com.demo.bank.entity.User;
import com.demo.bank.exceptions.ResourceNotFoundException;
import com.demo.bank.repository.UserRespository;
import com.demo.bank.services.impl.UserServiceImpl;

@RestController
@RequestMapping(path = "/bank", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {

	@Autowired
	UserRespository userRespository;

	@Autowired
	UserServiceImpl userServiceImpl;

	// get all users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRespository.findAll();
	}

	// create User rest api
	@PostMapping("/saveuser")
	public User createUser(@RequestBody UserDto userDto) {
		return userServiceImpl.saveUser(userDto);
	}

	// get User by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}

	// create User rest api
	@PostMapping("/getUserByUsername")
	public List<User> getUserByUsername(@RequestBody LoginRequest username) {
		return userServiceImpl.getUserByUserName(username);
	}
}
