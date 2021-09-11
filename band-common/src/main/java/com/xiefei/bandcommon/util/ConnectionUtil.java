package com.xiefei.bandcommon.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author faye
 * @create 2021-09-2021/9/9-17:02
 */
public class ConnectionUtil {
    private static Logger logger = LoggerFactory.getLogger(ConnectionUtil.class);

    public static Connection getConnection(){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setPort(5672);
            Connection connection = factory.newConnection();
            return connection;
        } catch (IOException e) {
            return null;
        } catch (TimeoutException e) {
            return null;
        }


    }

}
