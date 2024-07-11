package com.vinisolon.app.consumers;

import com.vinisolon.app.dtos.TestObjectRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.vinisolon.app.utils.JsonConverterUtil.toClazz;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.test.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Object> message) {
        log.info("Message received: {}", message.value());
        var clazz = toClazz(message.value(), TestObjectRequest.class);
        log.info("Class converted: {}", clazz);
    }

}
