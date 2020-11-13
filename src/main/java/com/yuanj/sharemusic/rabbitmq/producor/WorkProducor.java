package com.yuanj.sharemusic.rabbitmq.producor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 第二种：分工模型
 */
public class WorkProducor {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        //创建队列
        //1:队列名称
        //2：队列是否持久化
        //3：是否独占队列
        //4：是否自动删除队列
        //5：额外参数
        channel.queueDeclare("work",true,false,false,null);
        //1:交换机名
        //2:队列名
        //3：额外参数：消息持久化
        //4：消息内容
        for (int i = 1; i < 20; i++) {
            channel.basicPublish("","work", MessageProperties.PERSISTENT_TEXT_PLAIN,(i+" I don't know how to do.").getBytes());
        }
    }
}
