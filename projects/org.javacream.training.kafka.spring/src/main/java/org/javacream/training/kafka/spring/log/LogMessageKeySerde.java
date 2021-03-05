package org.javacream.training.kafka.spring.log;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

public class LogMessageKeySerde implements Serializer<LogMessageKey>, Deserializer<LogMessageKey> {

	@Override
	public LogMessageKey deserialize(String topic, byte[] data) {
		return new LogMessageKey(new String(data));
	}

	@Override
	public byte[] serialize(String topic, LogMessageKey data) {
		return data.getKey().getBytes();
	}

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}


}
