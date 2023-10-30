package com.queue.queueService.interfaces;

public interface RabbitMqGateway {
    void sendMessage (String queueName, String message);
    String receiveMessage(String QueueName);
}
