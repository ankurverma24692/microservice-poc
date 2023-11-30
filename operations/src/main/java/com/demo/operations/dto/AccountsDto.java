package com.demo.operations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {
 
	private Long customerId;
	
	private String accountType;
	
	private String bankName;

	private String bankBranch;

	private Long balance;
}
