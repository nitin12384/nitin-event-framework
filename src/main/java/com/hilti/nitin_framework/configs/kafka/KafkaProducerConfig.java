package com.hilti.nitin_framework.configs.kafka;

import lombok.Getter;

@Getter
public class KafkaProducerConfig extends KafkaBaseConfig {
    private static KafkaProducerConfig defaultKafkaProducerConfig =
            new KafkaProducerConfig("localhost:9092");

    public static KafkaProducerConfig getDefaultKafkaProducerConfig() {
        return defaultKafkaProducerConfig;
    }

    public KafkaProducerConfig(String bootstrapServerAddress){
        super(bootstrapServerAddress);
    }
}
