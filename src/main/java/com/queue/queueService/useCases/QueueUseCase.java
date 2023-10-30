package com.queue.queueService.useCases;

import com.queue.queueService.Adapters.RabbitMqAdapter;
import com.queue.queueService.infra.config.RabbitConfig;
import com.queue.queueService.interfaces.RabbitMqGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueUseCase {

   private final RabbitMqAdapter rabbitMqAdapter;

   public QueueUseCase(RabbitMqAdapter rabbitMqAdapter, RabbitConfig rabbitConfig){
       this.rabbitMqAdapter = rabbitMqAdapter;

   }
   public void sendMessagetToQueue(String queueName, String message){
       rabbitMqAdapter.sendMessage(queueName, message);
   }

   public String receiveMessageFromQueue(String queueName){
       return rabbitMqAdapter.receiveMessage(queueName);
   }
}
