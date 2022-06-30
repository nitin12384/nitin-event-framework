package com.hilti.nitin_framework.configs.activemq;

public class ActiveMQConsumerConfig extends ActiveMQBaseConfig{

    private static ActiveMQConsumerConfig defaultActiveMQConsumerConfig =
            new ActiveMQConsumerConfig();

    public static ActiveMQConsumerConfig getDefault() {
        return defaultActiveMQConsumerConfig;
    }

    public ActiveMQConsumerConfig(){
        String host = "localhost"; // change if ActiveMQ is
        // installed on another system
        String port = "61616";
        // Creating Factory for connection
        String brokerUrl = "tcp://" + host + ":" + port ;

        super.initSessionConnection(brokerUrl);

    }
}
