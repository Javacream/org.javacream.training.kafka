package org.javacream.training.kafka.spring.log;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

public class LogPartitioner implements Partitioner {

    public int partition(final String topic,
                         final Object objectKey,
                         final byte[] keyBytes,
                         final Object value,
                         final byte[] valueBytes,
                         final Cluster cluster) {

        final List<PartitionInfo> partitionInfoList =
                cluster.availablePartitionsForTopic(topic);
        final int partitionSize = partitionInfoList.size();
        final int criticalPartition = partitionSize - 1;
        final int partitionCount = partitionSize- 1;

        final String key = ((LogMessageKey) objectKey).getKey();
        int count;
        if (key.contains("CRITICAL")) { 
            count = criticalPartition;
        } else {
            count = Math.abs(key.hashCode()) % partitionCount;
        }
        return count;

    }

	public void configure(Map<String, ?> configs) {
		// nothing needed
		
	}

	public void close() {
		// nothing needed
		
	}


}
