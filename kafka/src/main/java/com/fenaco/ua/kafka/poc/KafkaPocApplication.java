package com.fenaco.ua.kafka.poc;


import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;





@SpringBootApplication()
public class KafkaPocApplication {
	
	public static final AtomicInteger msgProduceCounter = new AtomicInteger(0);
	public static final AtomicInteger msgConsumeCounter = new AtomicInteger(0);
	
	public static final int ANZAHL_MESSAGES = 30000;
	
	public static volatile boolean finish = false;
	
	public static StopWatch globalStopWatch = new StopWatch();
	
	@Autowired
	private MessageProducer producer;
	
	@Autowired
	private MessageListener consumer;
	
	@Autowired
	private ApplicationContext appContext;
	

    public static void main(String[] args) throws Exception {
		globalStopWatch.start();
    	ConfigurableApplicationContext context = SpringApplication.run(KafkaPocApplication.class, args);
     }
    
	@Bean
	public CommandLineRunner start(KafkaTemplate<String, Message> template) {
		
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

    	Properties props = new Properties();
    	props.put("bootstrap.servers", "192.168.1.103:9092");
    	Producer<String,Message> kafkaProducer = new KafkaProducer<>(props, new StringSerializer(), new KafkaJsonSerializer());
		MessageProducer producer = (MessageProducer)appContext.getBean(MessageProducer.class);		
		for (int i = 1; i <= ANZAHL_MESSAGES; i++) {
			String message = "Test " + i;
			producer.sendMessage(kafkaProducer, "Test " + i);
			System.out.println("Nachricht wurde versendet: " + message);
		}

	}

}
