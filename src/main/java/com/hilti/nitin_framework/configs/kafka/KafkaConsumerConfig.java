package com.hilti.nitin_framework.configs.kafka;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaConsumerConfig extends KafkaBaseConfig{
    private String groupId;
    private static KafkaConsumerConfig defaultKafkaConsumerConfig =
            new KafkaConsumerConfig("default-group", "localhost:9092");

    public static KafkaConsumerConfig getDefaultKafkaConsumerConfig(){
        return defaultKafkaConsumerConfig;
    }
    public KafkaConsumerConfig(String groupId, String bootstrapServerAddress){
        super(bootstrapServerAddress);
        this.groupId = groupId;
    }

}
