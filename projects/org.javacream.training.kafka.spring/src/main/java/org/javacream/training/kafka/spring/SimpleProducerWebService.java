package org.javacream.training.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleProducerWebService {

	@Autowired
	private SimpleProducer producer;

	@PostMapping(path="kafka/publish/{message}")
	public void sendMessageToKafkaTopic(@PathVariable("message") String message) {
		this.producer.sendMessage(message);
	}
}
