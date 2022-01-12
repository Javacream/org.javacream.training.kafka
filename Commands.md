# Commands to prepare Kafka Cluster

## Create simple topic with one partition

bin/kafka-topics.sh --zookeeper h2908727.stratoserver.net:2181 --create --topic simple --partitions 1 --replication-factor 1

## describe topic

bin/kafka-topics.sh --bootstrap-server  h2908727.stratoserver.net:9092 --describe --topic simple_topic

## Create topic with three partitions

bin/kafka-topics.sh --zookeeper h2908727.stratoserver.net:2181 --create --topic simple_partitioned --partitions 3 --replication-factor 1

## Create topic with three partitions and replication

bin/kafka-topics.sh --zookeeper h2908727.stratoserver.net:2181 --create --topic simple_partitioned_replicated --partitions 3 --replication-factor 3


## describe all Consumers in all groups
./bin/kafka-consumer-groups.sh --bootstrap-server  h2908727.stratoserver.net:9092 --all-groups --describe

##remove consumer group
bin/kafka-consumer-groups.sh --bootstrap-server h2908727.stratoserver.net:9092 --delete --group sawitzki_group1

## show offsets of topic

./bin/kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list h2908727.stratoserver.net:9092 --topic simple_topic --time -1

## play around

https://gist.github.com/ursuad/e5b8542024a15e4db601f34906b30bb5

## show configuration

bin/kafka-configs --bootstrap-server h2908727.stratoserver.net:9092 --entity-type brokers --entity-name 0 --describe

## Show all brokers
./bin/zookeeper-shell.sh h2908727.stratoserver.net:2181 ls /brokers/ids

## delete topic

./bin/kafka-topics.sh -- zookeeper h2908727.stratoserver.net:2181 -- delete -- topic logs_sawitzki


