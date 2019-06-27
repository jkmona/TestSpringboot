package com.test.haval.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class HomeApiController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(path = "/hello")
    public String sayHello(){
        kafkaTemplate.send("Test", "121","myMessage");
        return "hello word";
    }
}
