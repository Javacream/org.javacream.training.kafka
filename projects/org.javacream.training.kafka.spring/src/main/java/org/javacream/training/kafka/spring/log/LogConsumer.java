package org.javacream.training.kafka.spring.log;

import java.io.IOException;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer {

	@KafkaListener(id = "log_sawitzki", topicPartitions = {@TopicPartition(topic = "logs_sawitzki", partitions = {"0", "1"})})
	public void listen1(List<LogMessage> logMessages) throws IOException {
			logMessages.forEach(message -> System.out.println("CRITICAL: " + message));
	}
}