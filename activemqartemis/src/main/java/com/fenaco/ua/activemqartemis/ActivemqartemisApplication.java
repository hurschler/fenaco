package com.fenaco.ua.activemqartemis;

import java.util.Base64;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import javax.jms.ConnectionFactory;
import javax.jms.Session;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.util.StopWatch;

@SpringBootApplication
@EnableJms
public class ActivemqartemisApplication {

	@Value("${myqueue}")
	private String queue;
	
	// @Autowired
	private ProducerNonTx producer;
	
	@Autowired
	private ProducerTx producerTx;
	
	public static final AtomicInteger msgProduceCounter = new AtomicInteger(0);
	public static final AtomicInteger msgConsumeCounter = new AtomicInteger(0);
	
	public static final int ANZAHL_MESSAGES = 30000;
	
	public static volatile boolean finish = false;
	
	public static StopWatch globalStopWatch = new StopWatch();;
	
	public static void main(String[] args) {

		globalStopWatch.start();

		ConfigurableApplicationContext context = SpringApplication.run(ActivemqartemisApplication.class, args);
	
		
	}
	
	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		factory.setConcurrency("8-10");
	    factory.setCacheLevel(DefaultMessageListenerContainer.CACHE_CONSUMER); 
		return factory;
	}	


	@Bean
	public CommandLineRunner start() {
		
		// Step 1 sende eine einfache Nachricht
		CommandLineRunner cmdLineRunner = init();
		
		return cmdLineRunner;
	}

	private CommandLineRunner init() {
		return args -> {
		
			// Experiment 1 > Szenario 1: einfaches Nachrichten senden
			// simpleSendMessage();
			
			// Experiment 1 > Szenario 2: 30'000 Nachrichten senden
			// sendAlotOfMessages();
			
					
			// ---------- Producer wechseln @Component auskommentieren, application.prop transaction Flag wechseln ----------- 
			// Experiment 1 > Szenario 3: sende eine grosse Nachricht (30MB)
			sendLargeMessage();
			
			// Experiment 2 > Szenario 1: sende eine Nachricht mit Transaction Rollback
			// sendMessageTransactional();
			// sendMessageTransactionalWithException();			
		};
	}

	private void sendMessageTransactionalWithException() {
		producerTx.sendWithException("Simple-Message with Exception");
		
	}

	private void sendMessageTransactional() {
		producerTx.send("Simple-Message");
	}

	private void sendAlotOfMessages() {
		for (int i = 1; i <= ANZAHL_MESSAGES; i++) {
			String message = "Test " + i;
			producer.send("Test " + i);
			System.out.println("Nachricht wurde versendet: " + message);
		}
	}

	private void simpleSendMessage() {
		producer.send("Simple-Message");
	}
	
	private void sendLargeMessage() {
		Message largeMessage = new Message("Large Message");
		largeMessage.setBase64(toBase64String(createLargeByteArray()));
		producerTx.sendLargeMessage(largeMessage);
	}
	
	
	private void sendMessageWithRollback() {
		try {
			producer.send("Test 1");
			producer.sendWithException("Test 2");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	private byte[] createLargeByteArray() {
	      // create random object
	      Random randomno = new Random();
	      // create byte array
	      byte[] nbyte = new byte[20000000];
	      // put the next byte in the array
	      randomno.nextBytes(nbyte);
	      return nbyte;
	}
	
	private Byte[] toByteObjects(byte[] bytes) {
	    return IntStream.range(0, bytes.length)
	            .mapToObj(i -> bytes[i])
	            .toArray(Byte[]::new);
	}
	
	private String toBase64String(byte[] byteArray) {
		return Base64.getEncoder().encodeToString(byteArray);
	}
	
	


}
