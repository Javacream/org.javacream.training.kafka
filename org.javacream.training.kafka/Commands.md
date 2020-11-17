# Commands to prepare Kafka Cluster

## Create simple topic with one partition

bin/kafka-topics.sh --zookeeper h2908727.stratoserver.net:2181 --create --topic simple --partitions 1 --replication-factor 1


## Create topic with three partitions

bin/kafka-topics.sh --zookeeper h2908727.stratoserver.net:2181 --create --topic sawitzki --partitions 3 --replication-factor 1

## Create topic with three partitions and replication

bin/kafka-topics.sh --zookeeper h2908727.stratoserver.net:2181 --create --topic sawitzki_replicated --partitions 3 --replication-factor 3
