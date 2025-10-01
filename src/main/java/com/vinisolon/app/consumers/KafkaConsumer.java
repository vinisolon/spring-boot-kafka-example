package com.vinisolon.app.consumers;

import com.vinisolon.app.dtos.Request;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${my.topic}", groupId = "${my.group.id}")
    public void listener(ConsumerRecord<String, Request> message) {
        log.info("message={}", message);
        log.info("value={}", message.value());
    }

}
