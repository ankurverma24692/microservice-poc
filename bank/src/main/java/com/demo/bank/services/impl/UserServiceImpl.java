package com.demo.bank.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bank.dto.LoginRequest;
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
	UserRespository userRespository;

	@Override
	public List<User> getUserByUserName(LoginRequest login) {
		
		return userRespository.searchUserByUserName(login.getUsername());
	}

	@Override
	public User saveUser(UserDto userDto) {
		User user = UserMapper.mapUserDtoToUser(new User(), userDto);
		return userRespository.save(user);
	}

}
