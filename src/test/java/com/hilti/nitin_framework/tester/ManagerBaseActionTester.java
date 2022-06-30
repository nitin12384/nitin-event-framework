package com.hilti.nitin_framework.tester;

import com.hilti.nitin_framework.configs.MessagingTech;
import com.hilti.nitin_framework.core.Manager;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerBaseActionTester {

    public void setup_manager(String topicName, MessagingTech messagingTech){
        Manager.getInstance().setup(topicName, messagingTech);

        assertNotNull(Manager.getInstance().getMessageStorage());

    }

    public void start_consumer(){
        Manager.getInstance().start_consumer();
    }

    public void publish_message(String message){
        assertTrue(Manager.getInstance().produce(message));
    }

    public void validate_produced(String message) throws Exception{
        Manager.getInstance().validateProduced(message);
    }

    public void validate_consumed_after_timeout(String message, int timeout) throws Exception {
        Thread.sleep(timeout);
        Manager.getInstance().validateConsumed(message);
    }
    public void validate_consumed(String message) throws Exception {
        Manager.getInstance().validateConsumed(message);
    }

    public static void test_all_basic(MessagingTech messagingTech){

        ManagerBaseActionTester tester = new ManagerBaseActionTester();
        String topicName = "topic1";
        String message = "Message 1";
        int timeout_for_consumer_validation = 1000;
        assertAll(
                ()->tester.setup_manager(topicName, MessagingTech.KAFKA),
                ()->tester.start_consumer(),
                ()->tester.publish_message(message),
                ()->tester.validate_produced(message),
                ()->tester.validate_consumed_after_timeout(message,
                        timeout_for_consumer_validation)
        );
    }

    public static void test_multiple_message(MessagingTech messagingTech, int messageCount) throws Exception{
        ManagerBaseActionTester tester = new ManagerBaseActionTester();
        String topicName = "topic1";

        List<String> msgs = new ArrayList<>();
        for(int i=0; i<messageCount; i++){
            msgs.add("Message-"+i);
        }

        int timeout_for_consumer_validation = 1000;
        assertAll(
                ()->tester.setup_manager(topicName, messagingTech),
                ()->tester.start_consumer()
        );

        for(int i=0; i<messageCount; i++){
            String msg = msgs.get(i);
            assertAll(
                    ()->tester.publish_message(msg),
                    ()->tester.validate_produced(msg)
            );
        }

        // gives exception
        Thread.sleep(timeout_for_consumer_validation);

        for(int i=0; i<messageCount; i++){
            String msg = msgs.get(i);
            assertAll(
                    ()->tester.validate_consumed(msg)
            );
        }
    }


}
