package com.fenaco.ua.kafka.poc;



import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class MessageProducer {

	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    @Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

    @Value(value = "${greeting.topic.name}")
    private String greetingTopicName;

    // @Transactional   
    public void sendMessage(Producer kafkaProducer, String message) {
    	kafkaProducer.send(new ProducerRecord<>("TOPIC", "0", new Message("Test")));  	
    	System.out.println("Send Message: " + message);
    	KafkaPocApplication.msgProduceCounter.getAndIncrement();
    }
    
    @Transactional   
    public void sendTransactionl() {    	
		this.kafkaTemplate.executeInTransaction(kafkaTemplate -> {
				kafkaTemplate.send("topic2", "Test Transaction");
			return null;
		});
    }

    	
  

}