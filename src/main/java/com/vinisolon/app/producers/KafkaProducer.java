package com.vinisolon.app.producers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static com.vinisolon.app.utils.JsonConverterUtil.toJson;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(Object payload, String topic) {
        log.info("Publishing Object: {} in Topic: {}", payload, topic);

        var message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }

    public void publishJson(Object payload, String topic) {
        var json = toJson(payload);

        log.info("Publishing Json: {} in Topic: {}", json, topic);

        var message = MessageBuilder.withPayload(json)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }

}
