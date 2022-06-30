package com.hilti.nitin_framework.producers.activemq;

import com.hilti.nitin_framework.configs.activemq.ActiveMQProducerConfig;
import com.hilti.nitin_framework.core.MessageStorage;
import com.hilti.nitin_framework.producers.BaseProducer;
import com.hilti.nitin_framework.utils.InternalLogger;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

public class SimpleActiveMQProducer extends BaseProducer {

    @Override
    public boolean produce(String topicName, String messageText, MessageStorage messageStorage) {
        MessageProducer producer = ActiveMQMessageProducerFactory.createMessageProducer(topicName);
        ActiveMQProducerConfig config = ActiveMQProducerConfig.getDefault();

        try {
            TextMessage message = config.getSession().createTextMessage(messageText);
            producer.send(message);

            // successfully sent
            super.onSuccessfulProduce(topicName, messageText, messageStorage);
            return true;
        }
        catch (JMSException e) {
            InternalLogger.log("Exception while sending message : " + e);
            return false;
        }
    }
}
