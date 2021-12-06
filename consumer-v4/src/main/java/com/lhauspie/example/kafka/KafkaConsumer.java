package com.lhauspie.example.kafka;

import com.lhauspie.example.kafka.message.MessageKey;
import com.lhauspie.example.kafka.message.MessageValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"#{'${app.kafka.consumer.topic}'.split(',')}"})
    public void receive(
            @Payload MessageValue message,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) MessageKey key,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
        LOGGER.info("#########################################################################################");
        LOGGER.info("Metadata received: partition={} / topic={} / ts={}", partition, topic, ts);
        LOGGER.info("Key received: {}", key);
        LOGGER.info("Message received: {}", message);
        LOGGER.info("Key orgId: {}", key.getOrgId());
        LOGGER.info("Key objectId: {}", key.getObjectId());
        LOGGER.info("Message orgId: {}", message.getOrgId());
        LOGGER.info("Message objectId: {}", message.getObjectId());
        LOGGER.info("Message code: {}", message.getCode());
        LOGGER.info("Message label: {}", message.getLabel());
        LOGGER.info("Message dateTime: {}", message.getDateTime());
    }
}
