package org.javacream.training.kafka.spring.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleLogWebService {
	@Autowired
	private KafkaTemplate<String, LogMessage> kafkaTemplate;

	@PostMapping(path="kafka/log/{level}/{message}")
	public void sendMessageToKafkaTopic(@PathVariable("level") String level, @PathVariable("message") String message) {
		kafkaTemplate.send("logs_sawitzki", level, new LogMessage(level, message));
	}
}
