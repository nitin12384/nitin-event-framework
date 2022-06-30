package com.hilti.nitin_framework.producers.activemq;

import com.hilti.nitin_framework.configs.activemq.ActiveMQProducerConfig;
import com.hilti.nitin_framework.utils.InternalLogger;

import javax.jms.Destination;
import javax.jms.MessageProducer;

public class ActiveMQMessageProducerFactory {
    public static MessageProducer createMessageProducer(String topicName){
        // take default config and create a producer
        return createMessageProducer(topicName,
                ActiveMQProducerConfig.getDefault());
    }

    public static MessageProducer createMessageProducer(String topicName, ActiveMQProducerConfig config){
        try{
            Destination destination = config.getSession().createTopic(topicName);
            return config.getSession().createProducer(destination);
        }
        catch (Exception e){
            InternalLogger.log("Exception while creating producer in activemq " + e);
            return null;
        }
    }
}
