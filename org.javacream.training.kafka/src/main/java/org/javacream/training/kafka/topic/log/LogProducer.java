package org.javacream.training.kafka.topic.log;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.javacream.training.kafka.Configuration;

public class LogProducer {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", Configuration.BOOTSTRAP_SERVERS);
		props.put("key.serializer", "org.javacream.training.kafka.topic.log.LogMessageKeySerde");
		props.put("value.serializer", "org.javacream.training.kafka.topic.log.LogMessageValueSerde");
		props.put("acks", "all"); 
		props.put("retries", "3");
		props.put("max.in.flight.requests.per.connection", "1");
		Producer<LogMessage, LogMessage> producer = new KafkaProducer<>(props);

		LogMessage lm = new LogMessage("CRITICAL", "a critical message");
		ProducerRecord<LogMessage, LogMessage> producerRecord = new ProducerRecord<LogMessage, LogMessage>("sawitzki", lm,
				lm);

		producer.send(producerRecord);

		producer.close();
	}

}
