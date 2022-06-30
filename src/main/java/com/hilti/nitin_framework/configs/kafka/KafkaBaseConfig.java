package com.hilti.nitin_framework.configs.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KafkaBaseConfig {
    private String bootstrapServerAddress;
}
