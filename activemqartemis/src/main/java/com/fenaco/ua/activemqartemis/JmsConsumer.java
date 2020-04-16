package com.fenaco.ua.activemqartemis;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// @Component
public class JmsConsumer {
	@Transactional
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Message message) {
	    System.out.println("Received <" + message.getId() + "> " + "Message Counter: " + ActivemqartemisApplication.msgConsumeCounter.incrementAndGet());
	    if (ActivemqartemisApplication.finish == false && ActivemqartemisApplication.msgProduceCounter.get() == ActivemqartemisApplication.ANZAHL_MESSAGES) {
	    	ActivemqartemisApplication.finish = true;
	    	ActivemqartemisApplication.globalStopWatch.stop();
	    	System.out.println("Alle Nachrichten verarbeitet (Anzahl Sekunden): " + ActivemqartemisApplication.globalStopWatch.getTotalTimeSeconds());
	    }    
	}
}
