package com.fenaco.ua.azureservicebus.azureservicebusspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class Producer {
    
	@Autowired
    private JmsTemplate jmsTemplate;

    private final Logger logger = LoggerFactory.getLogger(Producer.class);
	
    public String postMessage(String message) {
        logger.info("Sending message");
        jmsTemplate.convertAndSend("queue", new Message(message));
        return message;
    }
    
    
	@Transactional
	public void send(String message) {
	    System.out.println("Sending an email message with Transaction: " + message);	    
	    jmsTemplate.convertAndSend("queue", new Message("Hello Transaction please commit: " + message));
		AzureservicebusSpringApplication.msgProduceCounter.getAndIncrement();

	}

}
