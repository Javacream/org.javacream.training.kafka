package org.javacream.training.kafka.spring.log;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

public class LogMessageValueSerde implements Serializer<LogMessage>, Deserializer<LogMessage> {

	@Override
	public LogMessage deserialize(String topic, byte[] data) {
		return new LogMessage("", new String(data));
	}

	@Override
	public byte[] serialize(String topic, LogMessage data) {
		return data.getMessage().getBytes();
	}

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}


}
