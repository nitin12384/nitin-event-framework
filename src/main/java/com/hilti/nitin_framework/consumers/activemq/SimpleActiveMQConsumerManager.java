package com.hilti.nitin_framework.consumers.activemq;

import com.hilti.nitin_framework.consumers.BaseConsumerManager;
import com.hilti.nitin_framework.consumers.KafkaConsumeAction;
import com.hilti.nitin_framework.core.Manager;
import com.hilti.nitin_framework.core.MessageStorage;
import com.hilti.nitin_framework.utils.InternalLogger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;
import java.util.concurrent.CompletableFuture;

public class SimpleActiveMQConsumerManager extends BaseConsumerManager {

    private static SimpleActiveMQConsumerManager instance =
            new SimpleActiveMQConsumerManager();

    public static SimpleActiveMQConsumerManager getInstance() {
        return instance;
    }

    @Override
    public void startConsumer(String topicName) {
        // get a consumer
        MessageConsumer consumer = ActiveMQMessageConsumerFactory.createMessageConsumer(topicName);

        // start async
        CompletableFuture.runAsync(()->{
            this.constantConsumerPolling(consumer, topicName);
        });
    }



    public void constantConsumerPolling(MessageConsumer consumer, String topicName)
    {
        int timeout = 1000;

        while(true){
            try {
                Message message = consumer.receive(timeout);
                String messageString = null;
                // consumer action
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    messageString = textMessage.getText();
                } else {
                    throw new JMSException("Message is not of type TextMessage");
                    //messageString = message.toString();
                }
                MessageStorage messageStorage = Manager.getInstance().getMessageStorage();
                messageStorage.addConsumed(topicName, messageString);

            } catch (JMSException e) {
                InternalLogger.log("Exception while consuming message in activemq " + e);
            }

        }
    }


}
