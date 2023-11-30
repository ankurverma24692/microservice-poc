package com.demo.operations.mapper;

import com.demo.operations.dto.AccountsDto;
import com.demo.operations.entity.Accounts;

public class AccountsMapper {
	
	public static AccountsDto mapAccountsToAccountsDto(Accounts accounts,AccountsDto accountsDto) {
		accountsDto.setCustomerId(accounts.getCustomerId());
		accountsDto.setAccountType(accounts.getAccountType());
		accountsDto.setBankName(accounts.getBankName());
		accountsDto.setBankBranch(accounts.getBankBranch());
		accountsDto.setBalance(accounts.getBalance());
		return accountsDto;
		
	}
	
	public static Accounts mapAccountsDtoToAccounts(Accounts accounts,AccountsDto accountsDto) {
		accounts.setCustomerId(accountsDto.getCustomerId());
		accounts.setAccountType(accountsDto.getAccountType());
		accounts.setBankName(accountsDto.getBankName());
		accounts.setBankBranch(accountsDto.getBankBranch());
		accounts.setBalance(accountsDto.getBalance());
		return accounts;
		
	}
}
