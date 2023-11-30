package com.demo.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String role;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String email;
}
