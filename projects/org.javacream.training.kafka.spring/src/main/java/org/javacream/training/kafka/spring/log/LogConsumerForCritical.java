package org.javacream.training.kafka.spring.log;

import java.io.IOException;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class LogConsumerForCritical {

	@KafkaListener(id = "critical", topicPartitions = { @TopicPartition(topic = "simple", partitions = "2") })
	public void listen1(List<LogMessageValue> logMessages) throws IOException {
		logMessages.forEach(message -> System.out.println("CRITICAL: " + message));
	}
}