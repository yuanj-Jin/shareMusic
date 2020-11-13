package com.yuanj.sharemusic.rabbitmq.producor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.yuanj.sharemusic.rabbitmq.RabbitMQUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 第三种：广播模型
 */
public class FanOutProducor {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitMQUtil.getConnection();
        Channel channel=connection.createChannel();
        //将通道声明指定交换机
        //1:交换机名称
        //2：交换机类型
        channel.exchangeDeclare("inform","fanout");
        for (int i = 1; i <= 10; i++) {
            channel.basicPublish("inform","", MessageProperties.PERSISTENT_TEXT_PLAIN,(i+" but i adore you.").getBytes());
        }
    }
}
