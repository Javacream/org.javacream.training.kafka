package org.javacream.training.kafka.topic.simple;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.javacream.training.kafka.Configuration;

public class SimpleProducer {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", Configuration.BOOTSTRAP_SERVERS);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<String, String>(props);

		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("helloworld", null,
				"a simple message");

		producer.send(producerRecord);

		producer.close();
	}

}
