package com.xiefei.bandcommon.util;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ReturnListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author faye
 * @create 2021-09-2021/9/9-17:08
 */
public class send {
    private static final String QUEUE_NAME = "test_simple_queue";
    private static final String EXCHANGE_NAME = "exchange";


    public static void main(String[] args) throws IOException, TimeoutException {
        Map<String,Object> arg = new HashMap<String,Object>();
        arg.put("alternate-exchange","alterExchange");
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("normalExchange","direct",false,false,arg);
        channel.exchangeDeclare("alterExchange","fanout",false,false,null);
        channel.queueDeclare("normalQueue",false,false,false,null);
        channel.queueDeclare("alterQueue",false,false,false,null);

        channel.queueBind("normalQueue","normalExchange","normalRoute");
        channel.queueBind("alterQueue","alterExchange","");

        String messsage = "Nihao";
        channel.basicPublish("normalExchange","errorRoute",null,messsage.getBytes(StandardCharsets.UTF_8));




    }
}
