# Kafka - Several versions of the same schema to cohabit with Schema Registry

The purpose of this repo is to show how the schema registry versioning works and how the consumers can consume messages from different versions.

## How to run and experiment

Run Kafka locally:
```
$ docker compose up
```

Run each consumer in 4 different windows (or tabs):
```
$ cd consumer-v1
$ mvn spring-boot:run
```

Run the producer (that is a Spring Shell to produce messages of version you want on demand):
```
$ cd producer
$ mvn spring-boot:run
```

Then produce the message in the version you want:
```
shell:> produce --version 1
shell:> produce --version 2
shell:> produce --version 3
shell:> produce --version 4
```

And just watch how Consumers react to each message.

- The first consumer can read message in version 1, 2 and 3. The fourth schema version will make it failed.
- The second consumer can read message in version 1, 2 and 3. The fourth schema version will also make it failed.
- The third consumer can read message in version 1, 2, 3 and 4. No schema version will make it failed.
- The fourth consumer can read message in version 1, 2, 3 and 4. No schema version will make it failed.


## Just as a reminder

I did some manual things to make it work. So if you want to change schemas, you will have to do it on your own.

### Generate Producer Java classes from avro

```
$ cd producer
$ mvn avro:schema -DsourceDirectory=./src/main/avro/v1 -DoutputDirectory=target/generated-sources/avro/v1
$ mv target/generated-sources/avro/v1/com/lhauspie/example/kafka/message src/main/java/com/lhauspie/example/kafka/message/v1
$ mvn avro:schema -DsourceDirectory=./src/main/avro/v2 -DoutputDirectory=target/generated-sources/avro/v2
$ mv target/generated-sources/avro/v2/com/lhauspie/example/kafka/message src/main/java/com/lhauspie/example/kafka/message/v2
$ mvn avro:schema -DsourceDirectory=./src/main/avro/v3 -DoutputDirectory=target/generated-sources/avro/v3
$ mv target/generated-sources/avro/v3/com/lhauspie/example/kafka/message src/main/java/com/lhauspie/example/kafka/message/v3
$ mvn avro:schema -DsourceDirectory=./src/main/avro/v4 -DoutputDirectory=target/generated-sources/avro/v4
$ mv target/generated-sources/avro/v4/com/lhauspie/example/kafka/message src/main/java/com/lhauspie/example/kafka/message/v4
```

**Take care to change package name on first line of each java files.**

I had to change the generated Java classe for `MessageValue` to replace `new SpecificData()` by `SpecificData.get()` to make it work.

### Generate Consumers Java classes from avro

Each `consumer-v*` contains the right version of the avro schema in `src/main/avro` and has the `avro-maven-plugin` with the `generate-sources` phase configured to generate `schema` from avro files.

So Java classes are generated after a `mvn clean package`.


### Configuring Schema Compatibility

```
$ curl -X PUT -i -H "Content-Type: application/vnd.schemaregistry.v1+json" --data '{"compatibility": "BACKWARD"}' http://localhost:8081/config/my_topic-key
$ curl -X PUT -i -H "Content-Type: application/vnd.schemaregistry.v1+json" --data '{"compatibility": "BACKWARD"}' http://localhost:8081/config/my_topic-value
```
