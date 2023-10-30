package com.queue.queueService.infra.config;

import com.queue.queueService.Adapters.RabbitMqAdapter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
   public static final String QUEUE_NAME="emailData";
    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // Configure the RabbitTemplate if needed
        return rabbitTemplate;
    }

}