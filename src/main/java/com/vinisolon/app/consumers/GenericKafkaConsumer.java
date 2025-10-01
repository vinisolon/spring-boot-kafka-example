package com.vinisolon.app.consumers;

import com.vinisolon.app.dtos.Request;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import static com.vinisolon.app.utils.JsonConverterUtil.toClazz;
import static com.vinisolon.app.utils.JsonConverterUtil.toJson;

@Slf4j
@Service
public class GenericKafkaConsumer {

    //    @KafkaListener(topics = "${my.topic}", groupId = "${my.group.id}")
    public void listener(ConsumerRecord<String, String> message) {
        var obj = toClazz(message.value(), Request.class);

        log.info("Object {}", obj);
        log.info("Class {}", obj.getClass());

        var json = toJson(obj);

        log.info("Json {}", json);
    }

}
