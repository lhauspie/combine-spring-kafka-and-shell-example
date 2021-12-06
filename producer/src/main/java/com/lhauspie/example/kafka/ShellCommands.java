package com.lhauspie.example.kafka;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.specific.SpecificData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.Instant;
import java.util.Properties;

@ShellComponent
public class ShellCommands {

    private KafkaProducer<com.lhauspie.example.kafka.message.v1.MessageKey, com.lhauspie.example.kafka.message.v1.MessageValue> producerV1;
    private KafkaProducer<com.lhauspie.example.kafka.message.v2.MessageKey, com.lhauspie.example.kafka.message.v2.MessageValue> producerV2;
    private KafkaProducer<com.lhauspie.example.kafka.message.v3.MessageKey, com.lhauspie.example.kafka.message.v3.MessageValue> producerV3;
    private KafkaProducer<com.lhauspie.example.kafka.message.v4.MessageKey, com.lhauspie.example.kafka.message.v4.MessageValue> producerV4;

    public ShellCommands() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        producerV1 = new KafkaProducer<>(props);
        producerV2 = new KafkaProducer<>(props);
        producerV3 = new KafkaProducer<>(props);
        producerV4 = new KafkaProducer<>(props);
    }

    @ShellMethod(key = "produce", value = "Produce a message to Kafka")
    public String produce(@ShellOption(defaultValue = "1") Integer version) {
        switch (version) {
            case 1: produceV1(); break;
            case 2: produceV2(); break;
            case 3: produceV3(); break;
            case 4: produceV4(); break;
            default: throw new IllegalArgumentException("version has to be 1, 2 or 3");
        }
        return "Message produced with producerV" + version;
    }

    private void produceV3() {
        ProducerRecord record = new ProducerRecord<>(
                "my_topic",
                com.lhauspie.example.kafka.message.v3.MessageKey.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .build(),
                com.lhauspie.example.kafka.message.v3.MessageValue.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .build()
        );
        producerV3.send(record);
        producerV3.flush();
    }

    private void produceV4() {
        ProducerRecord record = new ProducerRecord<>(
                "my_topic",
                com.lhauspie.example.kafka.message.v4.MessageKey.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .build(),
                com.lhauspie.example.kafka.message.v4.MessageValue.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .setCode(PojoGenerator.generate(String.class))
                        .setLabel(PojoGenerator.generate(String.class))
                        .setDateTime(Instant.now())
                        .build()
        );
        producerV4.send(record);
        producerV4.flush();
    }

    private void produceV2() {
        SpecificData.get().addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
        ProducerRecord record = new ProducerRecord<>(
                "my_topic",
                com.lhauspie.example.kafka.message.v2.MessageKey.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .build(),
                com.lhauspie.example.kafka.message.v2.MessageValue.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .setCode(PojoGenerator.generate(String.class))
                        .setLabel(PojoGenerator.generate(String.class))
                        .setValue(PojoGenerator.generate(Integer.class))
                        .setDateTime(Instant.now())
                        .build()
        );
        producerV2.send(record);
        producerV2.flush();
    }

    private void produceV1() {
        ProducerRecord record = new ProducerRecord<>(
                "my_topic",
                com.lhauspie.example.kafka.message.v1.MessageKey.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .build(),
                com.lhauspie.example.kafka.message.v1.MessageValue.newBuilder()
                        .setOrgId(PojoGenerator.generate(String.class))
                        .setObjectId(PojoGenerator.generate(String.class))
                        .setCode(PojoGenerator.generate(String.class))
                        .setLabel(PojoGenerator.generate(String.class))
                        .setValue(PojoGenerator.generate(Integer.class))
                        .build()
        );
        producerV1.send(record);
        producerV1.flush();
    }
}