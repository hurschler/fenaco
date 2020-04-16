package com.fenaco.ua.azureservicebus.azureservicebusspring;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.StopWatch;



@SpringBootApplication
@EnableJms
public class AzureservicebusSpringApplication {

	public static final AtomicInteger msgProduceCounter = new AtomicInteger(0);
	public static final AtomicInteger msgConsumeCounter = new AtomicInteger(0);
	
	public static final int ANZAHL_MESSAGES = 30000;
	
	public static volatile boolean finish = false;
	
	public static StopWatch globalStopWatch = new StopWatch();;
		
	@Value("${myqueue}")
	private String queue;
	
	@Autowired
	private Producer producer;
	
	
	public static void main(String[] args) {

		globalStopWatch.start();

		
		SpringApplication.run(AzureservicebusSpringApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner start(JmsTemplate template) {
		
		// Step 1 sende eine einfache Nachricht
		CommandLineRunner cmdLineRunner = init();
		
		return cmdLineRunner;
	}

	private CommandLineRunner init() {
		return args -> {
			
			// Experiment 1 > Szenario 1: einfaches Nachrichten senden
			// simpleSendMessage();
			
			// Experiment 1 > Szenario 2: 30'000 Nachrichten senden
			sendAlotOfMessages();
			
			// Experiment 1 > Szenario 3: sende eine grosse Nachricht (30MB)
			
			// Experiment 2 > Szenario 1: sende eine Nachricht mit Transaction Rollback
				
		};
	}


	private void sendAlotOfMessages() {
		for (int i = 1; i <= ANZAHL_MESSAGES; i++) {
			String message = "Test " + i;
			producer.send("Test " + i);
			System.out.println("Nachricht wurde versendet: " + message);
		}
	}
	

}
