package com.hilti.nitin_framework.entity.serialization;

import com.hilti.nitin_framework.entity.MessageType;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Map;

public class MessageTypeDeserializer implements Deserializer<MessageType> {
    private boolean isKey;
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.isKey = isKey;
    }

    @Override
    public MessageType deserialize(String topic, byte[] data) {
        if(data == null){
            return null;
        }
        else{
            try{
                StringDeserializer deserializer = new StringDeserializer();
                String content = deserializer.deserialize(topic, data);
                return new MessageType(content);
            }
            catch (Exception e){
                throw new SerializationException("Exception " + e);
            }
        }
    }
}
