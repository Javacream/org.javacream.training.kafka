package org.javacream.training.kafka.topic.simple;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SimpleConsumer {

	public static void main(String[] args) {
		Properties consumerProperties = SimpleTopicConfiguration.CONSUMER;
		String topic = SimpleTopicConfiguration.TOPIC;

		@SuppressWarnings("resource")
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(consumerProperties);
		consumer.subscribe(Arrays.asList(topic));

		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());		
			}
		}

		// consumer.close(); //unreachable code
	}

}
