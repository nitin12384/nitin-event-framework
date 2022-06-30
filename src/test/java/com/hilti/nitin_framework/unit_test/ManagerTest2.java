package com.hilti.nitin_framework.unit_test;

import com.hilti.nitin_framework.configs.MessagingTech;
import com.hilti.nitin_framework.core.Manager;
import com.hilti.nitin_framework.tester.ManagerBaseActionTester;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ManagerTest2 {
    @Test
    public void stress_test_kafka() throws Exception{
        ManagerBaseActionTester.test_multiple_message(MessagingTech.KAFKA, 10000);
    }

    @Test
    public void stress_test_activemq() throws Exception{
        ManagerBaseActionTester.test_multiple_message(MessagingTech.ACTIVE_MQ, 10000);
    }
}
