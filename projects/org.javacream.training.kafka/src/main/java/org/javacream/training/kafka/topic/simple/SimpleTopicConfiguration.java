package org.javacream.training.kafka.topic.simple;

import java.util.Properties;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.javacream.training.kafka.Configuration;

public abstract class SimpleTopicConfiguration {
	public static final Properties PRODUCER;
	public static final Properties CONSUMER;
	public static final String TOPIC = "simple_topic";
	static {

		PRODUCER = new Properties();
		PRODUCER.put("bootstrap.servers", Configuration.BootstrapServers.REMOTE.getServers());
		PRODUCER.put("key.serializer", StringSerializer.class.getName());
		PRODUCER.put("value.serializer", StringSerializer.class.getName());
		PRODUCER.put("acks", "all"); 
		PRODUCER.put("retries", "3");
		PRODUCER.put("max.in.flight.requests.per.connection", "1");

		final String GROUP_ID = "simple";
		CONSUMER = new Properties();
		CONSUMER.put("bootstrap.servers", Configuration.BootstrapServers.REMOTE.getServers());
		CONSUMER.put("group.id", GROUP_ID);
		CONSUMER.put("enable.auto.commit", "true");
		CONSUMER.put("auto.commit.interval.ms", "1000");
		CONSUMER.put("key.deserializer", StringDeserializer.class.getName());
		CONSUMER.put("value.deserializer", StringDeserializer.class.getName());
		System.out.println(CONSUMER.getProperty("bootstrap.servers"));
	}
}
