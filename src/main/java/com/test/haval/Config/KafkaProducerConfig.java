package com.test.haval.Config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.producer.key-serializer}")
    private String keySerializer;
    @Value("${spring.kafka.producer.value-serializer}")
    private String valueSerializer;
    @Value("${spring.kafka.producer.batch-size}")
    private Integer batchSize;
    @Value("${spring.kafka.producer.retries}")
    private Integer retries;

    public KafkaProducerConfig() {
        //如果用-D 或者其它方式设置过，这里不再设置
        /*if (null == System.getProperty("java.security.auth.login.config")) {
            //请注意将 XXX 修改为自己的路径
            //这个路径必须是一个文件系统可读的路径，不能被打包到 jar 中
            System.setProperty("java.security.auth.login.config", "/jar/kafka_client_jaas.conf");
        }
        System.out.println("环境变量中已有config文件,kafka配置为:"+System.getProperty("java.security.auth.login.config"));*/
    }
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        /*if (StringUtils.isEmpty(jksLocation)) {
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, KafkaAliyunConfiguration.class.getClassLoader()
                    .getResource("kafka.client.truststore.jks").getPath());
        } else {
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, jksLocation);
        }*/
        //props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "KafkaOnsClient");
        //props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        //props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30 * 1000);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
