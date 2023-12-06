package com.demo.bank.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.bank.dto.LoginRequest;
import com.demo.bank.dto.LoginResponse;
import com.demo.bank.dto.UserDto;
import com.demo.bank.entity.User;

public interface UserService {

	public List<User> getUserByUserName(LoginRequest username);
	
	public User saveUser( UserDto userDto);
	
	public ResponseEntity<LoginResponse> verifyUserLogin(LoginRequest loginRequest);
}
