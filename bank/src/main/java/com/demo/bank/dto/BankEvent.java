package com.demo.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankEvent {

	private String message;
	
	private String status;
	
	private UserDto user;
	
}
