package com.hilti.nitin_framework.producers.kafka;

import com.hilti.nitin_framework.configs.kafka.KafkaProducerConfig;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerFactory {

    public static KafkaProducer<String, String> createProducer(){
        return createProducer(KafkaProducerConfig.getDefaultKafkaProducerConfig());
    }

    public static KafkaProducer<String, String> createProducer(KafkaProducerConfig config){
        return new KafkaProducer<String, String>(getKafkaProducerProperties(config));
    }

    public static Properties getKafkaProducerProperties(KafkaProducerConfig config){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                config.getBootstrapServerAddress());
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());

        return properties;

    }
}
