package org.javacream.training.kafka.spring.log;

import java.io.IOException;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class LogConsumerForCritical {

@KafkaListener(id = "log_sawitzkicritical", topicPartitions = {@TopicPartition(topic = "logs_sawitzki", partitions = "2")})
	public void listen1(List<LogMessage> logMessages) throws IOException {
			System.out.print("\"CRITICAL: \" + ");
			logMessages.forEach(System.out::println);
	}
}