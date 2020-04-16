package com.fenaco.ua.rabbitmq;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;





@SpringBootApplication
public class RabbitmqApplication {

    private static final boolean NON_DURABLE = false;
    private static final String MY_QUEUE_NAME = "myQueue";
    
	public static final int ANZAHL_MESSAGES = 30000;
	
	public static final AtomicInteger msgProduceCounter = new AtomicInteger(0);
	public static final AtomicInteger msgConsumeCounter = new AtomicInteger(0);

	public static volatile boolean finish = false;
	
	public static StopWatch globalStopWatch = new StopWatch();;
	
	
    @Autowired
    ProducerTransactional producer;

    public static void main(String[] args) {
    	
    	globalStopWatch.start();
    	
        SpringApplication.run(RabbitmqApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> {
        	init();
        };
    }
 
    
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }    
    
    
    private void init() {

		// Experiment 1 > Szenario 1: einfaches Nachrichten senden
		// simpleSendMessage();
		
		// Experiment 1 > Szenario 2: 30'000 Nachrichten senden
		sendAlotOfMessages();
		
		// Experiment 1 > Szenario 3: sende eine grosse Nachricht (30MB)
		
		// Experiment 2 > Szenario 1: sende eine Nachricht mit Transaction Rollback

    	
    	// sendMessageTransactional();
    	// template.convertAndSend("myQueue", "Hello, world!");
    	
    }

	private void sendAlotOfMessages() {
		for (int i = 1; i <= ANZAHL_MESSAGES; i++) {
			String message = "Test " + i;
			producer.send("Test " + i);
			System.out.println("Nachricht wurde versendet: " + message);
		}
	}
    
	private void sendMessageTransactional() {
		producer.send("Test Message");
		try {
			producer.send("Test Message with Exception");				
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

    @Bean
    public Queue myQueue() {
        return new Queue(MY_QUEUE_NAME, NON_DURABLE);
    }

    @RabbitListener(queues = MY_QUEUE_NAME)
    public void listen(Message in) {
        System.out.println("Message read from myQueue : " + in);
	    System.out.println("Received <" + in + "> " + "Message Counter: " + RabbitmqApplication.msgConsumeCounter.incrementAndGet());
	    if (RabbitmqApplication.finish == false && RabbitmqApplication.msgConsumeCounter.get() == RabbitmqApplication.ANZAHL_MESSAGES) {
	    	RabbitmqApplication.finish = true;
	    	RabbitmqApplication.globalStopWatch.stop();
	    	System.out.println("Alle Nachrichten verarbeitet (Anzahl Sekunden): " + RabbitmqApplication.globalStopWatch.getTotalTimeSeconds());
	    }    

    
    }
}
