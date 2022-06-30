package com.hilti.nitin_framework.unit_test;

import com.hilti.nitin_framework.configs.MessagingTech;

import com.hilti.nitin_framework.tester.ManagerBaseActionTester;
import org.junit.jupiter.api.Test;


public class ManagerBaseActionTest {
    @Test
    public void test_basic_kafka(){
        ManagerBaseActionTester.test_all_basic(MessagingTech.KAFKA);
    }
    @Test
    public void test_basic_activemq(){
        ManagerBaseActionTester.test_all_basic(MessagingTech.ACTIVE_MQ);
    }
}
