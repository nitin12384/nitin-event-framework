package com.hilti.nitin_framework.core;

import com.hilti.nitin_framework.configs.MessagingConfig;
import com.hilti.nitin_framework.configs.MessagingTech;
import com.hilti.nitin_framework.consumers.BaseConsumerManager;
import com.hilti.nitin_framework.exceptions.ExceptionMessages;
import com.hilti.nitin_framework.exceptions.ValidationException;
import com.hilti.nitin_framework.producers.BaseProducer;
import com.hilti.nitin_framework.validators.MessageValidator;

public class Manager {
    private static Manager instance = new Manager();

    private MessagingConfig config;
    private MessageStorage storage;
    private BaseConsumerManager consumerManager;
    private BaseProducer producer;

    public static Manager getInstance() {
        return Manager.instance;
    }

    public MessageStorage getMessageStorage(){
        return this.storage;
    }

    public void setup(String defaultTopicName, MessagingTech messagingTech){
        this.config = new MessagingConfig(defaultTopicName, messagingTech);
        this.consumerManager = MessageTechManager.getConsumer(messagingTech);
        this.producer = MessageTechManager.getProducer(messagingTech);
        this.storage = new MessageStorage();
    }

    public boolean produce(String message){
        // producer the message and add to storage
        // and not if there was any exception.
        return producer.produce(config.getDefaultTopicName() ,message, this.storage);
    }

    public void start_consumer(){
        consumerManager.startConsumer(config.getDefaultTopicName());
    }

    public void validateProduced(String message) throws Exception{
        if( ! MessageValidator.isProduced(storage, config.getDefaultTopicName(), message)){
            throw new ValidationException(ExceptionMessages.MESSAGE_NOT_PRODUCED);
        }
    }

    public void validateConsumed(String message)throws Exception{
        if( ! MessageValidator.isConsumed(storage, config.getDefaultTopicName(), message)){
            throw new ValidationException(ExceptionMessages.MESSAGE_NOT_CONSUMED);
        }

    }
}
