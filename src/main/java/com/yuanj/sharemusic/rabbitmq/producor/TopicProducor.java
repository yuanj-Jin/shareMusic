package com.yuanj.sharemusic.rabbitmq.producor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 第四种：路由模型---订阅
 */
public class TopicProducor {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        //将通道声明指定交换机
        //1:交换机名称
        //2：交换机类型
        channel.exchangeDeclare("topic_inform","topic");
        //发送
        for (int i = 1; i <= 10; i++) {
            channel.basicPublish("topic_inform","yuanj.info", MessageProperties.PERSISTENT_TEXT_PLAIN,(i+" sorry,i'll give up you.").getBytes());
        }
        RabbitMQUtil.closeConnection(channel,connection);
    }
}
