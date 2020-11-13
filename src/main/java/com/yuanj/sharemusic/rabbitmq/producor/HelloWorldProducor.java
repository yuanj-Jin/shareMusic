package com.yuanj.sharemusic.rabbitmq.producor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 第一种：点对点模型
 */
public class HelloWorldProducor {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        //创建队列
        //1:队列名称
        //2：队列是否持久化
        //3：是否独占队列
        //4：是否自动删除队列
        //5：额外参数
        channel.queueDeclare("helloworld",true,false,false,null);
        //1:交换机名
        //2:队列名
        //3：额外参数：消息持久化
        //4：消息内容
        channel.basicPublish("","helloworld", MessageProperties.PERSISTENT_TEXT_PLAIN,"what do you want for me?".getBytes());
    }
}
