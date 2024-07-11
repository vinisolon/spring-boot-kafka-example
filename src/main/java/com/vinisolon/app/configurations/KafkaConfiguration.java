package com.vinisolon.app.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Slf4j
@Configuration
public class KafkaConfiguration {

    @Value("${kafka.test.topic}")
    private String kafkaTestTopic;

    // Single topic
//    @Bean
//    public NewTopic buildKafkaTestTopic() {
//        log.info("Creating kafka topic: {}", kafkaTestTopic);
//        return TopicBuilder.name(kafkaTestTopic).build();
//    }

    // Multiple topics
    @Bean
    public KafkaAdmin.NewTopics buildKafkaTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(kafkaTestTopic).build(),
                TopicBuilder.name("multi-topic-builder-example").build()
        );
    }

}
