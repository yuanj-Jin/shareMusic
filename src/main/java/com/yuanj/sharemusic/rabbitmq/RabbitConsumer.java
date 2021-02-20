package com.yuanj.sharemusic.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 */
//@Component
//@RabbitListener(queuesToDeclare = @Queue(value = "su",durable = "false",autoDelete = "false"))
public class RabbitConsumer {

//    @RabbitHandler
    public void receive(String msg) {
        System.out.println(msg);
    }
}
