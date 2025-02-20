package com.vinisolon.app.consumers;

import com.vinisolon.app.dtos.Request;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.vinisolon.app.utils.JsonConverterUtil.toClazz;
import static com.vinisolon.app.utils.JsonConverterUtil.toJson;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${my.topic}", groupId = "${my.group.id}")
    public void listener(ConsumerRecord<String, String> mesage) {
        var obj = toClazz(mesage.value(), Request.class);

        log.info("Object {}", obj);
        log.info("Class {}", obj.getClass());

        var json = toJson(obj);

        log.info("Json {}", json);
    }

}
