package com.rmq.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.rmq.service.EventPublisher;

@Configuration
@EnableScheduling
@Profile("publisher")
public class EventPublisherConfiguration {

	@Bean
	public TopicExchange senderTopicExchange() {
		return new TopicExchange("eventExchange");
	}
	
	@Bean
	public EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange) {
		return new EventPublisher(rabbitTemplate, senderTopicExchange);
	}
}
