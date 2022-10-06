package com.stackroute.userservice.publisher;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.userservice.constants.UserServiceConstants;
import com.stackroute.userservice.dto.UserDTOPublisher;

@Component
public class UserProducer {

	private RabbitTemplate rabbitTemplate;

	private TopicExchange topicExchange;

	@Autowired
	public UserProducer(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.topicExchange = topicExchange;
	}

	public void sendMessageToRabbitMq(UserDTOPublisher userDTOPublisher) {
		System.err.println(topicExchange.getName());
		rabbitTemplate.convertAndSend(topicExchange.getName(), UserServiceConstants.ROUTING_KEY, userDTOPublisher);
	}

}
