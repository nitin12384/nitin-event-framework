package com.hilti.nitin_framework.producers.kafka;

import com.hilti.nitin_framework.core.Manager;
import com.hilti.nitin_framework.core.MessageStorage;

import com.hilti.nitin_framework.producers.BaseProducer;
import com.hilti.nitin_framework.utils.InternalLogger;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class SimpleKafkaProducer extends BaseProducer {

    private KafkaProducer<String, String> producer;

    public SimpleKafkaProducer(){
        producer = KafkaProducerFactory.createProducer();
    }

    @Override
    public boolean produce(String topicName, String msg, MessageStorage messageStorage) {
        RecordMetadata metadata = null;
        try{
            // synchronous publishing of message
            metadata = producer.send(
                    new ProducerRecord<>(topicName, msg)
            ).get();

            logPublishMetadata(metadata);

            // reached here means there was no exception
            super.onSuccessfulProduce(topicName,msg, messageStorage);

            return true;

        }
        catch (Exception e){
            InternalLogger.log("Exception while producing message + " + e.getStackTrace());

            return false;
        }
    }



    private void logPublishMetadata(RecordMetadata recordMetadata){
        InternalLogger.log("Successfully received the details as: \n" +
                "Topic:" + recordMetadata.topic() + "\n" +
                "Partition:" + recordMetadata.partition() + "\n" +
                "Offset" + recordMetadata.offset() + "\n" +
                "Timestamp" + recordMetadata.timestamp());
    }




}
