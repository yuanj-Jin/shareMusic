package com.yuanj.sharemusic.rabbitmq.consumer;

import com.rabbitmq.client.*;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Work2Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        /**
         * 能者多劳
         */
        channel.basicQos(1);//一次只能消费一个消息

        channel.basicConsume("work", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-1："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
