package com.hilti.nitin_framework.consumers.kafka;

import com.hilti.nitin_framework.configs.kafka.KafkaConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class KafkaConsumerFactory {
    public static KafkaConsumer<String, String> createKafkaConsumer(){
        return new KafkaConsumer<String, String>(getKafkaConsumerProperties(
                KafkaConsumerConfig.getDefaultKafkaConsumerConfig()
        ));
    }
    public static Properties getKafkaConsumerProperties(KafkaConsumerConfig config){

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                config.getBootstrapServerAddress());
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,
                config.getGroupId());

        // not sure why is this used ?
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return properties;

    }
}
