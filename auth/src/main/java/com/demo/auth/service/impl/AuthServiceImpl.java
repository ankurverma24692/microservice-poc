/**
 * 
 */
package com.demo.auth.service.impl;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.auth.config.JwtUtils;
import com.demo.auth.dto.LoginRequestDto;
import com.demo.auth.dto.LoginResponseDto;
import com.demo.auth.dto.TokenDto;
import com.demo.auth.service.AuthService;

import io.micrometer.common.util.StringUtils;


/**
 * 
 */

@Service
public class AuthServiceImpl implements AuthService {

	private final JwtUtils jwtUtils;

	private RestTemplate restTemplate;

	@Autowired
	public AuthServiceImpl(JwtUtils jwtUtils) {
		this.jwtUtils = jwtUtils;
		this.restTemplate = new RestTemplate();
	}

	@Override
	public ResponseEntity<TokenDto> generateToken(LoginRequestDto logRequest) {
		String validateUserUri = "http://localhost:9800/oauth2/verify-token";

		ResponseEntity<LoginResponseDto> loginResponse = restTemplate.postForEntity(validateUserUri,
				new HttpEntity<LoginRequestDto>(logRequest), LoginResponseDto.class);

		if (HttpStatus.OK != loginResponse.getStatusCode() || !loginResponse.hasBody()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		LoginResponseDto responseDto = loginResponse.getBody();
		if (Objects.isNull(responseDto) || (StringUtils.isBlank(responseDto.getUsername()))) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		String token = jwtUtils.generateJwtToken(responseDto.getUsername());
		String refToken = jwtUtils.generateRefreshToken(logRequest.getUsername());

		return ResponseEntity.ok(new TokenDto(logRequest.getUsername(), token, refToken, LocalDateTime.now()));

	}


	@Override
	public ResponseEntity<LoginResponseDto> verifyToken(TokenDto tokenRequest) {
		LoginResponseDto login = jwtUtils.validateJwtToken(tokenRequest.getToken());
		return ResponseEntity.ok(null);
	}

}
