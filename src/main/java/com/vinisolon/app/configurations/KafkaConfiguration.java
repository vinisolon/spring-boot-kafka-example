package com.vinisolon.app.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfiguration {

    @Value("${my.topic}")
    private String kafkaTopicName;

    @Bean
    public KafkaAdmin.NewTopics buildKafkaTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(kafkaTopicName)
                        .build()
        );
    }

}
