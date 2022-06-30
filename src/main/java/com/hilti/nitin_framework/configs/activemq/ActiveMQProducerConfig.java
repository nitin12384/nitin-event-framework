package com.hilti.nitin_framework.configs.activemq;

public class ActiveMQProducerConfig extends ActiveMQBaseConfig{

    private static ActiveMQProducerConfig defaultActiveMQProducerConfig =
            new ActiveMQProducerConfig();

    public static ActiveMQProducerConfig getDefault() {
        return defaultActiveMQProducerConfig;
    }

    public ActiveMQProducerConfig(){
        String host = "localhost"; // change if ActiveMQ is
        // installed on another system
        String port = "61616";
        // Creating Factory for connection
        String brokerUrl = "tcp://" + host + ":" + port ;

        super.initSessionConnection(brokerUrl);

    }
}
