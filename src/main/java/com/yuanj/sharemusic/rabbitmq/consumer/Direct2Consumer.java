package com.yuanj.sharemusic.rabbitmq.consumer;

import com.rabbitmq.client.*;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Direct2Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        /**
         * 能者多劳
         */
        channel.basicQos(1);//一次只能消费一个消息
        channel.exchangeDeclare("direct_inform","direct");//绑定交换机
        String queue=channel.queueDeclare().getQueue();//获取临时队列
        channel.queueBind(queue,"direct_inform","error");//基于rout key 绑定队列
        channel.queueBind(queue,"direct_inform","info");//基于rout key 绑定队列
        channel.queueBind(queue,"direct_inform","warning");//基于rout key 绑定队列
        channel.basicConsume(queue, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-1："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
