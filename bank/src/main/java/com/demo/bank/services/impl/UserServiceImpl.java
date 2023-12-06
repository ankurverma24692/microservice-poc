package com.demo.bank.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.bank.dto.LoginRequest;
import com.demo.bank.dto.LoginResponse;
import com.demo.bank.dto.UserDto;
import com.demo.bank.entity.User;
import com.demo.bank.mapper.UserMapper;
import com.demo.bank.repository.UserRespository;
import com.demo.bank.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	UserRespository userRepository;

	@Override
	public List<User> getUserByUserName(LoginRequest login) {
		
		return userRepository.searchUserByUserName(login.getUsername());
	}

	@Override
	public User saveUser(UserDto userDto) {
		User user = UserMapper.mapUserDtoToUser(new User(), userDto);
		return userRepository.save(user);
	}

	@Override
	public ResponseEntity<LoginResponse> verifyUserLogin(LoginRequest loginRequest) {
		User user = userRepository.findByUsernamePassword(loginRequest.getUsername(), loginRequest.getPassword());
		if(Objects.isNull(user)) {
			return ResponseEntity.notFound().build();
		}
		
		LoginResponse loginResponseDto = new LoginResponse(user.getUsername(), user.getRole());
		return ResponseEntity.ok(loginResponseDto);
	}
}
