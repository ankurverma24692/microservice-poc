package com.demo.operations.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.operations.dto.AccountsDto;
import com.demo.operations.entity.Accounts;
import com.demo.operations.mapper.AccountsMapper;
import com.demo.operations.repository.AccountsRepository;
import com.demo.operations.service.AccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService{
	
	@Autowired
	AccountsRepository accountsRepository;
	
	@Override
	public Accounts createAccont(AccountsDto accountsDto) {
		Accounts accounts = AccountsMapper.mapAccountsDtoToAccounts(new Accounts(), accountsDto);
		return accountsRepository.save(accounts);
	}

}
