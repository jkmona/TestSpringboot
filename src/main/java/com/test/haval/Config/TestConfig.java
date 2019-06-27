package com.test.haval.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {
    Logger log = LoggerFactory.getLogger("TestConfig");
    @Value("${proxy.host}")
    private String host;

    @Autowired
    private Environment env;
    public void display(){
        log.info("host:" + host);
        log.info("env - port:" + env.getProperty("proxy.port"));
        log.info("randomT: " + env.getProperty("proxy.randomT"));
    }
}
