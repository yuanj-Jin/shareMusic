package com.yuanj.sharemusic.rabbitmq.consumer;

import com.rabbitmq.client.*;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class HelloWorldConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        //一次消费只能消费一个，不能全部拿到
        channel.basicQos(1);
        //1:队列名
        //2：自动消息确认：true消费者自动向rabbitmq确认消息消费,false
        channel.basicConsume("helloworld", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });
    }
}
