package org.javacream.training.kafka.topic.simple;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {

	public static void main(String[] args) {

		Properties producerProperties = SimpleTopicConfiguration.PRODUCER;
		String topic = SimpleTopicConfiguration.TOPIC;
		String key = null;
		String value = "simple message";
		Producer<String, String> producer = new KafkaProducer<String, String>(producerProperties);
		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key, value);
		producer.send(producerRecord);
		producer.close();
	}

}
