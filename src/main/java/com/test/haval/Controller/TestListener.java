package com.test.haval.Controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @KafkaListener(id = "test-a", topics = {"Test"})
    public void listen(ConsumerRecord<String, String> memssage) {
        System.out.println(String.format("message.value:%s", memssage.value()));

    }
}
