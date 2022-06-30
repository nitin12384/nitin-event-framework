package com.hilti.nitin_framework.core;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageStorage {

    private HashMap<String, List<String>> messageConsumed = new HashMap<>();
    private HashMap<String, List<String>> messageProduced = new HashMap<>();
    // key : topic name
    // value : list of messages

    public void addConsumed(String topicName, String message) {
        this.addToMap(topicName, message, this.messageConsumed);
    }

    public void addProduced(String topicName, String message) {
        this.addToMap(topicName, message, this.messageProduced);
    }

    private void addToMap(String topicName, String message, HashMap<String, List<String>> messageMap){
        messageMap.putIfAbsent(topicName, new ArrayList<String>());
        messageMap.get(topicName)
                .add(message);
    }

    public HashMap<String, List<String>> getMessageConsumed() {
        return this.messageConsumed;
    }

    public HashMap<String, List<String>> getMessageProduced() {
        return this.messageProduced;
    }
}
