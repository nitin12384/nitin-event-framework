package com.hilti.nitin_framework.consumers.activemq;

import com.hilti.nitin_framework.configs.activemq.ActiveMQConsumerConfig;
import com.hilti.nitin_framework.configs.activemq.ActiveMQProducerConfig;
import com.hilti.nitin_framework.utils.InternalLogger;

import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;

public class ActiveMQMessageConsumerFactory {
    public static MessageConsumer createMessageConsumer(String topicName){
        // take default config and create a Consumer
        return createMessageConsumer(topicName,
                ActiveMQConsumerConfig.getDefault());
    }

    public static MessageConsumer createMessageConsumer(String topicName, ActiveMQConsumerConfig config){
        try{
            Destination destination = config.getSession().createTopic(topicName);
            return config.getSession().createConsumer(destination);
        }
        catch (Exception e){
            InternalLogger.log("Exception while creating Consumer in activemq " + e);
            return null;
        }
    }
}
