package org.javacream.training.kafka.streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 * A minimal Kafka Streams topology:
 * reads from topic 'input-text', converts values to upper-case,
 * and writes to topic 'output-text'.
 */
@Configuration
@EnableKafka
@EnableKafkaStreams
public class TopologyConfig {

    public static final String INPUT_TOPIC = "input-text";
    public static final String OUTPUT_TOPIC = "output-text";

    @Bean
    public KStream<String, String> uppercaseStream(StreamsBuilder builder) {
        KStream<String, String> input = builder.stream(
                INPUT_TOPIC,
                Consumed.with(Serdes.String(), Serdes.String())
        );

        KStream<String, String> upper = input.mapValues(value -> value == null ? null : value.toUpperCase());

        upper.to(OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));
        return upper;
    }
}
