package com.demo.bank.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6349619007520233785L;
	
	private String username;
	private String role;
}
