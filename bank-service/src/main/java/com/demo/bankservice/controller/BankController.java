package com.demo.bankservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.dto.BankEvent;
import com.demo.bank.dto.UserDto;
import com.demo.bank.entity.User;
import com.demo.bankservice.kafka.BankProducer;

@RestController
@RequestMapping("/api/v1")
public class BankController {
	
	private BankProducer bankProducer;

	public BankController(BankProducer bankProducer) {
		this.bankProducer = bankProducer;
	}
	
	@PostMapping("/user")
	public String CreateUser(@RequestBody UserDto userDto) {
		
		BankEvent bankEvent = new BankEvent();
		bankEvent.setStatus("PENDING");
		bankEvent.setMessage("User status is in pending state");
		bankEvent.setUser(userDto);
		
		bankProducer.sendMessage(bankEvent);
		
		return "User create successfully....";
		
	}

}
