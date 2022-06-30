package com.hilti.nitin_framework.producers;

import com.hilti.nitin_framework.core.MessageStorage;

public abstract class BaseProducer {
    // produce
    public abstract boolean produce(String topicName, String msg, MessageStorage messageStorage);

    protected void onSuccessfulProduce(String topicName, String msg, MessageStorage messageStorage) {
        // store data
        messageStorage.addProduced(topicName, msg);
    }
}
