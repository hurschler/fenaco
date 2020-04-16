package com.fenaco.ua.activemqartemis;

import javax.jms.Destination;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// @Component
public class ProducerNonTx {

	@Autowired
	JmsTemplate jmsTemplate;

	// Wird für Transaktionen nicht verwendet
	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
	    CachingConnectionFactory cachingConnectionFactory =
	        new CachingConnectionFactory(new ActiveMQConnectionFactory());
	    cachingConnectionFactory.setSessionCacheSize(10);	
	    return cachingConnectionFactory;
	}
	
	@Bean
	public Destination destination() {
	    return new ActiveMQQueue("mailbox");
	}	

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	}	

	// Wird für Transaktionen nicht verwendet	
	@Bean
	public JmsTemplate jmsTemplate() {
	    JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
		// JmsTemplate jmsTemplate = new JmsTemplate();
	    jmsTemplate.setDefaultDestination(destination());
	    jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());	    
	    jmsTemplate.setMessageIdEnabled(false);
	    jmsTemplate.setMessageTimestampEnabled(false);
	    return jmsTemplate;
	}	
	
	
	public void sendWithException(String message) {
	    System.out.println("Sending an email message.");
	    jmsTemplate.convertAndSend("mailbox", new Message("Hello Transaction please rollback"));
		throw new RuntimeException("Failer please rollback Transaction");
	}
	
	public void send(String message) {
	    System.out.println("Sending an email message with Transaction: " + message);	    
	    jmsTemplate.convertAndSend("mailbox", new Message("Hello Transaction please commit: " + message));
		ActivemqartemisApplication.msgProduceCounter.getAndIncrement();

	}
	
}
