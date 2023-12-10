package com.demo.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.auth.dto.LoginRequestDto;
import com.demo.auth.dto.LoginResponseDto;
import com.demo.auth.dto.TokenDto;
import com.demo.auth.service.AuthService;

@RestController
@RequestMapping(path = "/oauth2")
public class TokenController {

	private final AuthService authService;
	
	@Autowired
	public TokenController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(value = "/genrate-token", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenDto> tokenGeneration(@RequestBody LoginRequestDto logRequest){
		return  authService.generateToken(logRequest);
	}
	
	@PostMapping(value = "/verify-token", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponseDto> verifyToken(TokenDto tokenRequest){
		return  authService.verifyToken(tokenRequest);
	}
}
