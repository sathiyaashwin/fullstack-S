package com.example.entity;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.config.DirectExchangeConfig;

@Component
public class Consumer {
	
	@RabbitListener(queues = DirectExchangeConfig.ROUTING_KEY)
	public void consumeMessage(String message) {
		
		System.out.println("Recevied One Message :="+message);
	}

}
