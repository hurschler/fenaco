package com.fenaco.ua.kafka.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Gary Russell
 * @since 2.2.1
 */
@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
	@PostMapping(path = "/send/foo/{what}")
	public void sendFoo(@PathVariable String what) {
		this.kafkaTemplate.executeInTransaction(kafkaTemplate -> {
				kafkaTemplate.send("topic2", what);
			return null;
		});
				
	}

}