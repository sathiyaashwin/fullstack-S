package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {
	
	public static final String EXCHANGE = "direct_exchange";
	public static final String ROUTING_KEY = "student_details";

	@Bean
	public Queue directConfigQueue() {
		return new Queue(ROUTING_KEY, false);
	}
	
	@Bean
	public DirectExchange direct(){
		return new DirectExchange(EXCHANGE);
	}
	@Bean
	public Binding bindingDirect(DirectExchange direct , Queue directConfigQueue) {
		
		return BindingBuilder.bind(directConfigQueue).to(direct).with(ROUTING_KEY);
	}
}
