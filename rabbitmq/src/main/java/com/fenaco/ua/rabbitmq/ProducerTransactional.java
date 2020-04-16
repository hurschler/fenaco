package com.fenaco.ua.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ProducerTransactional {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Transactional
	public void send(String messageText) {
	    rabbitTemplate.convertAndSend("myQueue", new Message("test Transactional with commit: " + messageText));
		RabbitmqApplication.msgProduceCounter.getAndIncrement();
	}
	
	@Transactional
	public void sendWithException() {
	    rabbitTemplate.convertAndSend("myQueue", new Message("test Transactional with Exception"));
	    throw new RuntimeException("Failor on Transaction");
	}
	
}
