package com.hilti.nitin_framework.validators;

import com.hilti.nitin_framework.core.MessageStorage;

import java.util.List;
import java.util.Map;

// validate if a message is consumed or not
public class MessageValidator {

    public static boolean isMessageContentInMap(Map<String, List<String>> messagesMap,
                                         String topicName, String message)
    {
        List<String> messageList = messagesMap.get(topicName);
        if(messageList != null){
            for(String m : messageList){
                if(m.equals(message)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isProduced(MessageStorage storage, String topicName,
                                     String message)
    {
        return isMessageContentInMap(storage.getMessageProduced(), topicName, message);
    }
    public static boolean isConsumed(MessageStorage storage, String topicName, String message)
    {
        return isMessageContentInMap(storage.getMessageConsumed(), topicName, message);
    }

}
