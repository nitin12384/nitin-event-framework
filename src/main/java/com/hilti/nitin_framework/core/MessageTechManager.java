package com.hilti.nitin_framework.core;

import com.hilti.nitin_framework.configs.MessagingTech;
import com.hilti.nitin_framework.consumers.BaseConsumerManager;
import com.hilti.nitin_framework.consumers.activemq.SimpleActiveMQConsumerManager;
import com.hilti.nitin_framework.consumers.kafka.SimpleKafkaConsumerManager;
import com.hilti.nitin_framework.producers.BaseProducer;
import com.hilti.nitin_framework.producers.activemq.SimpleActiveMQProducer;
import com.hilti.nitin_framework.producers.kafka.SimpleKafkaProducer;
import com.hilti.nitin_framework.utils.InternalLogger;

public class MessageTechManager {
    public static BaseProducer getProducer(MessagingTech messagingTech){
        BaseProducer producer = null;
        if(messagingTech == MessagingTech.KAFKA){
            producer = new SimpleKafkaProducer();
        }
        else{
            producer = new SimpleActiveMQProducer();
        }

        return producer;

    }
    public static BaseConsumerManager getConsumer(MessagingTech messagingTech){
        BaseConsumerManager consumerManager = null;
        if(messagingTech == MessagingTech.KAFKA){
            consumerManager = new SimpleKafkaConsumerManager();
        }
        else{
            consumerManager = new SimpleActiveMQConsumerManager();
        }
        return consumerManager;
    }
}
