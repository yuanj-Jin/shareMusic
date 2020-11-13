package com.yuanj.sharemusic.rabbitmq.consumer;

import com.rabbitmq.client.*;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Work1Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.basicQos(1);//一次只能消费一个消息
//        channel.basicConsume("work", true, new DefaultConsumer(channel) {
        //flase:手动确认
        channel.basicConsume("work", false, new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-1："+new String(body));
                //1：确认是哪个消息
                //2：是否开启多个消息同时确认
                channel.basicAck(envelope.getDeliveryTag(),false);
                //平均分配时，消费者消费效率慢时，会导致消息堵塞
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
