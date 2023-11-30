package com.demo.operations.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.operations.dto.AccountsDto;
import com.demo.operations.entity.Accounts;
import com.demo.operations.exceptions.ResourceNotFoundException;
import com.demo.operations.repository.AccountsRepository;
import com.demo.operations.services.impl.AccountsServiceImpl;

@RestController
@RequestMapping(path = "/operations", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AccountsController {

	@Autowired
	AccountsRepository accountsRepository;
	
	@Autowired
	AccountsServiceImpl accountsServiceImpl;
	
	// get all Accounts
	@GetMapping("/getAllAccounts")
	public List<Accounts> getAllAccounts() {
		return accountsRepository.findAll();
	}

	// create Account rest api
	@PostMapping("/createAccount")
	public Accounts createAccount(@RequestBody AccountsDto accountsDto) {
		return accountsServiceImpl.createAccont(accountsDto);
	}

	// get User by id rest api
	@GetMapping("/account/{account_id}")
	public ResponseEntity<Accounts> getUserById(@PathVariable Long account_id) {
		Accounts account = accountsRepository.findById(account_id)
				.orElseThrow(() -> new ResourceNotFoundException("Account not exist with id :" + account_id));
		return ResponseEntity.ok(account);
	}
}
