package com.demo.bank.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.bank.dto.BankEvent;
import com.demo.bank.repository.UserRespository;
import com.demo.bank.services.impl.UserServiceImpl;

@Service
public class UserConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(BankEvent bankEvent) {

		LOGGER.info(String.format("Bank Event recieved in Bank service  => %s", bankEvent.toString()));
		
		// save the user event into the database
		userServiceImpl.saveUser(bankEvent.getUser());
		
	}
}
