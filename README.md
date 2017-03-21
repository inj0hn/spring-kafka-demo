# spring-kafka-demo
Spring Kafka Integration Demo

<h5>Prerequisites</h5>

* Apache Kafka
* Apache ZooKeeper

<h5>Installation</h5>

1. Download Kafka
<br>$ wget http://mirror.stjschools.org/public/apache/kafka/0.10.2.0/kafka_2.11-0.10.2.0.tgz
<br>$ tar -xzf kafka_2.11-0.9.0.0.tgz
<br>$ cd kafka_2.11-0.9.0.0

2. Start the ZooKeeper
<br>$ bin/zookeeper-server-start.sh config/zookeeper.properties

3. Start Kafka Server
<br>$ bin/kafka-server-start.sh config/server.properties

4. Create a topic
<br>$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic vagrant-kafka-poc

5. List topics
<br>$ bin/kafka-topics.sh --list --zookeeper localhost:2181
