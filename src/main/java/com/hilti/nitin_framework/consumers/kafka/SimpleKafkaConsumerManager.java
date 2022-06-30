package com.hilti.nitin_framework.consumers.kafka;

import com.hilti.nitin_framework.consumers.BaseConsumerManager;
import com.hilti.nitin_framework.consumers.KafkaConsumeAction;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class SimpleKafkaConsumerManager extends BaseConsumerManager {

    private static SimpleKafkaConsumerManager instance =
            new SimpleKafkaConsumerManager();

    public static SimpleKafkaConsumerManager getInstance() {
        return instance;
    }

    @Override
    public void startConsumer(String topicName) {
        // get a consumer
        KafkaConsumer<String, String> consumer = KafkaConsumerFactory.createKafkaConsumer();

        // subscribe to topic
        consumer.subscribe(Arrays.asList(topicName));

        // start async
        CompletableFuture.runAsync(()->{
            this.constantConsumerPolling(consumer, new KafkaConsumeAction());
        });
    }



    public void constantConsumerPolling(KafkaConsumer<String, String> consumer,
                                        KafkaConsumeAction consumeAction)
    {
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord record : records){
                consumeAction.accept(record);
            }
        }
    }


}
