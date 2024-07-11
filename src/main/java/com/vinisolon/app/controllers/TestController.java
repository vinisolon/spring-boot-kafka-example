package com.vinisolon.app.controllers;

import com.vinisolon.app.dtos.TestObjectRequest;
import com.vinisolon.app.producers.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class TestController {

    private final KafkaProducer kafkaProducer;

    public TestController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Value("${kafka.test.topic}")
    private String kafkaTestTopic;

    @PostMapping("/publish")
    public ResponseEntity<?> publish(@RequestBody TestObjectRequest request) {
        kafkaProducer.publish(request, kafkaTestTopic);
        return ResponseEntity.ok("Request body sent to kafka producer");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<?> publishJson(@RequestBody TestObjectRequest request) {
        kafkaProducer.publishJson(request, kafkaTestTopic);
        return ResponseEntity.ok("Request body sent to kafka producer");
    }

    @PostMapping("/publish-string/{message}")
    public ResponseEntity<?> publish(@PathVariable("message") String message) {
        kafkaProducer.publish(message, kafkaTestTopic);
        return ResponseEntity.ok("String request sent to kafka producer");
    }

}
