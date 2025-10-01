package com.vinisolon.app.controllers;

import com.vinisolon.app.dtos.Request;
import com.vinisolon.app.producers.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final KafkaProducer kafkaProducer;

    @Value("${my.topic}")
    private String kafkaTestTopic;

    @PostMapping("/kafka/publish")
    public ResponseEntity<String> publish(@RequestBody Request request) {
        kafkaProducer.publish(kafkaTestTopic, request);
        return ResponseEntity.ok("Request body sent to kafka producer!");
    }

}
