package com.queue.queueService.Adapters;

import com.queue.queueService.infra.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.queue.queueService.interfaces.RabbitMqGateway;
import org.springframework.stereotype.Component;

@Component

public class RabbitMqAdapter {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqAdapter(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queueName, String message) {
        System.out.println("chamando o adapter");
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
    }


    public String receiveMessage(String QueueName) {
        System.out.println("receive messsage");
        return null;
    }
}
