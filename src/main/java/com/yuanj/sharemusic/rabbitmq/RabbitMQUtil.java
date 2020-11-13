package com.yuanj.sharemusic.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtil {

    static ConnectionFactory connectionFactory;
    static {
        connectionFactory=new ConnectionFactory();
        //连接rabbitMQ
        connectionFactory.setHost("193.112.152.51");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/sm");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        Connection connection=connectionFactory.newConnection();
        return connection;
        //创建队列
        //1:队列名称
        //2：队列特性是否持久化
        //3：是否独占队列
        //4：是否自动删除
        //5：额外参数
//        channel.queueDeclare("helloworld",false,false,false,null);
//        return channel;
    }

    public static void closeConnection(Channel channel,Connection connection){
        try {
            if(channel!=null){
                channel.close();
            }
            if( connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
