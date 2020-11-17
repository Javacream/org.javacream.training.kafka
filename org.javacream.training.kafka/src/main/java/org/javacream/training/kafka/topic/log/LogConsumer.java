package org.javacream.training.kafka.topic.log;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.javacream.training.kafka.Configuration;

public class LogConsumer {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", Configuration.BOOTSTRAP_SERVERS);
		props.put("group.id", "sawitzki_group1");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.javacream.training.kafka.topic.log.LogMessageKeySerde");
		props.put("value.deserializer", "org.javacream.training.kafka.topic.log.LogMessageValueSerde");

		@SuppressWarnings("resource")
		KafkaConsumer<LogMessage, LogMessage> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("sawitzki"));

		while (true) {
			ConsumerRecords<LogMessage, LogMessage> records = consumer.poll(Duration.ofMillis(100));
			for (ConsumerRecord<LogMessage, LogMessage> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());		
			}
		}

		// consumer.close(); //unreachable code
	}

}
