package com.fenaco.ua.activemqartemis;


import javax.jms.Destination;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProducerTx {

	@Autowired
	JmsTemplate jmsTemplateTx;
	
	@Bean
	public Destination destinationTx() {
	    return new ActiveMQQueue("mailbox-tx");
	}	

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverterTx() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	}			
	
	@Transactional
	public void sendWithException(String message) {
	    System.out.println("Sending an email message.");
	    jmsTemplateTx.convertAndSend("mailbox", new Message("Hello Transaction please rollback"));
		throw new RuntimeException("Failer please rollback Transaction");
	}
	
	@Transactional
	public void send(String message) {
	    System.out.println("Sending an email message with Transaction: " + message);	    
	    jmsTemplateTx.convertAndSend("mailbox", new Message("Hello Transaction please commit: " + message));
	}
	
	@Transactional
	public void sendLargeMessage(Message message) {
	    System.out.println("Sending an email message with Transaction: " + message.getId());	    
	    jmsTemplateTx.convertAndSend("mailbox", message);
	}
	
}
