package com.vinisolon.app.consumers;

import com.vinisolon.app.dtos.TestObjectRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.test.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(TestObjectRequest message) {
        log.info("Message received: {}", message);
    }

}
