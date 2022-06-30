package com.hilti.nitin_framework.configs.activemq;

import com.hilti.nitin_framework.utils.InternalLogger;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Session;

public class ActiveMQBaseConfig {

    protected Session session;
    protected Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Session getSession() {
        return session;
    }

    protected void initSessionConnection(String brokerUrl){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);

        // put this part in base class
        try{
            this.connection = factory.createConnection();
            this.connection.start();
            this.connection.setExceptionListener(new ExceptionListener() {
                @Override
                public void onException(JMSException exception) {
                    InternalLogger.log("Exception in JMS connection. : " + exception);
                }
            });

            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        }
        catch(Exception e){
            InternalLogger.log("Exception while creating JMS connection and session in ActiveMQBaseConfig. : " + e);
        }
    }


}

