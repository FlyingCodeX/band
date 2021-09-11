package com.xiefei.bandcommon.util;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * @author faye
 * @create 2021-09-2021/9/9-17:41
 */
public class Consumer {
    private static final String QUEUE_NAME = "alterQueue";
    private static final String EXCHANGE_NAME = "alterExchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        connection.addShutdownListener(new ShutdownListener() {
            @Override
            public void shutdownCompleted(ShutdownSignalException e) {
                System.out.println(e.getReason());
            }
        });
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties();
        AMQP.BasicProperties.Builder builder = basicProperties.builder();
//        DefaultConsumer consumer = new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                String exchange = envelope.getExchange();
//                long deliveryTag = envelope.getDeliveryTag();
//                String routingKey = envelope.getRoutingKey();
//                String msg = new String(body,"utf-8");
//                System.out.println(msg);
//            }
//        };
//
//        channel.basicConsume(QUEUE_NAME,true,consumer);
        GetResponse getResponse = channel.basicGet(QUEUE_NAME, false);
        String s = new String(getResponse.getBody(), "utf-8");
        channel.basicAck(getResponse.getEnvelope().getDeliveryTag(),true);
        System.out.println(s);

        channel.close();
        connection.close();


    }
}
