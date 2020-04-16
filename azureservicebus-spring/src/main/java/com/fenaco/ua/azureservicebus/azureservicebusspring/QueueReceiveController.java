package com.fenaco.ua.azureservicebus.azureservicebusspring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class QueueReceiveController {

    private static final String QUEUE_NAME = "queue";

    private final Logger logger = LoggerFactory.getLogger(QueueReceiveController.class);

    @JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Message message) {
 	    System.out.println("Received <" + message.getId() + "> " + "Message Counter: " + AzureservicebusSpringApplication.msgConsumeCounter.incrementAndGet());
	    if (AzureservicebusSpringApplication.finish == false && AzureservicebusSpringApplication.msgProduceCounter.get() == AzureservicebusSpringApplication.ANZAHL_MESSAGES) {
	    	AzureservicebusSpringApplication.finish = true;
	    	AzureservicebusSpringApplication.globalStopWatch.stop();
	    	System.out.println("Alle Nachrichten verarbeitet (Anzahl Sekunden): " + AzureservicebusSpringApplication.globalStopWatch.getTotalTimeSeconds());
	    }    

    }
}