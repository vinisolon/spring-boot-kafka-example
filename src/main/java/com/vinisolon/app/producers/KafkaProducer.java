package com.vinisolon.app.producers;

import com.vinisolon.app.dtos.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Request> kafkaTemplate;

    public void publish(String topic, Request request) {
        log.info("topic={} request={}", request, topic);

        var message = MessageBuilder.withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        log.info("message={}", message);

        kafkaTemplate.send(message);
    }

}
