package com.example.demo.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanOutExchangeConfig {

	@Bean
	public Queue fanOutQueue() {
		return new Queue("dhana.ece.student",false);
	}
	
	@Bean
	public Queue fanOutQueue2() {
		return new Queue("dhana.cse.student",false);
	}
	@Bean
	public FanoutExchange exchange() {
		return new FanoutExchange("dhan-sri-college");
	}
	
	@Bean
	public Binding binding1(FanoutExchange exchange, Queue fanoutQueue1) {
		return BindingBuilder.bind(fanoutQueue1).to(exchange);
	}
	
	@Bean
	public Binding binding2(FanoutExchange exchange, Queue fanoutQueue2) {
		return BindingBuilder.bind(fanoutQueue2).to(exchange);
	}
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
