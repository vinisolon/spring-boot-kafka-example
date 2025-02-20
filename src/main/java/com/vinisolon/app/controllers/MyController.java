package com.vinisolon.app.controllers;

import com.vinisolon.app.dtos.Request;
import com.vinisolon.app.producers.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class MyController {

    private final KafkaProducer kafkaProducer;

    public MyController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Value("${my.topic}")
    private String kafkaTestTopic;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Request request) {
        kafkaProducer.publish(request, kafkaTestTopic);
        return ResponseEntity.ok("Request body sent to kafka producer!");
    }

}
