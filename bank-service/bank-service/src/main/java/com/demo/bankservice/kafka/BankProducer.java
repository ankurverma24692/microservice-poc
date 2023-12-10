package com.demo.bankservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.bank.dto.BankEvent;

@Service
public class BankProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BankProducer.class);

	private NewTopic topic;
	
	private KafkaTemplate<String, BankEvent> kafkaTemplate;

	public BankProducer(NewTopic topic, KafkaTemplate<String, BankEvent> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(BankEvent event) {
		LOGGER.info(String.format("Bank Event => %s", event.toString()));
		
		// create Message
		Message<BankEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		kafkaTemplate.send(message);
	}
}
