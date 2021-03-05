package org.javacream.training.kafka.spring.log;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

public class LogMessageValueSerde implements Serializer<LogMessageValue>, Deserializer<LogMessageValue> {

	@Override
	public LogMessageValue deserialize(String topic, byte[] data) {
		StringTokenizer stringTokenizer = new StringTokenizer(new String(data), "=");
		return new LogMessageValue(stringTokenizer.nextToken(), stringTokenizer.nextToken());
	}

	@Override
	public byte[] serialize(String topic, LogMessageValue data) {
		return (data.getLevel()+"="+data.getMessage()).getBytes();
	}

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}


}
