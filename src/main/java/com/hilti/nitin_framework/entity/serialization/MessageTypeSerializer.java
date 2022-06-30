package com.hilti.nitin_framework.entity.serialization;

import com.hilti.nitin_framework.entity.MessageType;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;

public class MessageTypeSerializer implements Serializer<MessageType> {

    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.isKey = isKey;
    }

    @Override
    public byte[] serialize(String topic, MessageType data) {
        if(data == null){
            return null;
        }

        try{
            StringSerializer serializer = new StringSerializer();
            return serializer.serialize(topic, data.getContent());
        }
        catch (Exception e){
            throw new SerializationException("Exception " + e);
        }
    }
}
