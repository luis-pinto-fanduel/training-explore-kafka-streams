# Kafka Streams


## Set up Kafka Environment using Docker

- This should set up the Zookeeper and Kafka Broker in your local environment

```aidl
docker-compose up
```

### Verify the Local Kafka Environment

- Run this below command

```
docker ps
```

- You should see zookeeper and kafka containers up and running

### Interacting with Kafka

#### Produce Messages

- This  command should take care of logging in to the Kafka container.

```
docker exec -it broker bash
```

- Command to produce messages in to the Kafka topic.

```
kafka-console-producer --broker-list localhost:9092 --topic greetings
```

- Publish to **greetings** topic with key and value

```
kafka-console-producer --broker-list localhost:9092 --topic greetings --property "key.separator=-" --property "parse.key=true"

```

- Publish to **greetings-spanish** topic with key and value

```
 kafka-console-producer --broker-list localhost:9092 --topic greetings_spanish --property "key.separator=-" --property "parse.key=true"
```

#### Consume Messages

- This  command should take care of logging in to the Kafka container.

```
docker exec -it broker bash
```
- Command to consume messages from the Kafka topic.

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic greetings_uppercase
```

- Command to consume with Key

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic greetings_uppercase --from-beginning -property "key.separator= - " --property "print.key=true"
```

- Other Helpful Kafka Consumer commands

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic general_orders
```

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic restaurant_orders
```

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic ktable-words-store-changelog --from-beginning
```

- Command to read from the Internal Aggregate topic

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic aggregate-KSTREAM-AGGREGATE-STATE-STORE-0000000003-changelog --from-beginning -property "key.separator= - " --property "print.key=true"
```


### List Topics

- This  command should take care of logging in to the Kafka container.

```
docker exec -it broker bash
```

- Command to list the topics.

```
kafka-topics --bootstrap-server localhost:9092 --list
```
