package com.hilti.nitin_framework.consumers;

import com.hilti.nitin_framework.core.Manager;
import com.hilti.nitin_framework.core.MessageStorage;
import com.hilti.nitin_framework.utils.InternalLogger;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.function.Consumer;

public class KafkaConsumeAction implements Consumer<ConsumerRecord<String, String>> {
    @Override
    public void accept(ConsumerRecord<String, String> record) {
        // save in storage
        MessageStorage messageStorage = Manager.getInstance().getMessageStorage();
        messageStorage.addConsumed(record.topic(), record.value());

        // logger
        InternalLogger.log("KafkaConsumeAction. Topic : " + record.topic()
            + " Value : " + record.value()
        );
    }
}
