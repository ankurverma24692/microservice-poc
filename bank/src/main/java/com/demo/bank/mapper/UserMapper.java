package com.demo.bank.mapper;

import com.demo.bank.dto.UserDto;
import com.demo.bank.entity.User;

public class UserMapper {

	public static UserDto mapUserToUserDto(User user,UserDto userDto) {
		userDto.setRole(user.getRole());
		userDto.setName(user.getName());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		return userDto;
		
	}
	
	public static User mapUserDtoToUser(User user,UserDto userDto) {
		user.setRole(userDto.getRole());
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		return user;
		
	}
}
