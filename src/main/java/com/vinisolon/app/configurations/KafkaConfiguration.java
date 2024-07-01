package com.vinisolon.app.configurations;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Slf4j
@Configuration
public class KafkaConfiguration {

    @Value("${kafka.test.topic}")
    private String kafkaTestTopic;

    @Bean
    public NewTopic buildKafkaTestTopic() {
        log.info("Creating kafka topic: {}", kafkaTestTopic);
        return TopicBuilder.name(kafkaTestTopic).build();
    }

}
