package com.test.haval.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestConfig2 {
    Logger log = LoggerFactory.getLogger("TestConfig1");

    private Integer port;
    private Integer timeout;

    private List<String> servers = new ArrayList<>();

    public void display(){
        log.info("tomcat host:" + getPort());
        log.info("tomcat timeout:" + getTimeout());
        log.info("tomcat servers:" + getServers());
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
