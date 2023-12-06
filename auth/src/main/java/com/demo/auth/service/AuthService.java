/**
 * 
 */
package com.demo.auth.service;

import org.springframework.http.ResponseEntity;

import com.demo.auth.dto.LoginRequestDto;
import com.demo.auth.dto.LoginResponseDto;
import com.demo.auth.dto.TokenDto;

/**
 * 
 */
public interface AuthService {

	ResponseEntity<TokenDto> generateToken(LoginRequestDto logRequest);

	ResponseEntity<LoginResponseDto> verifyToken(TokenDto tokenRequest);

}
