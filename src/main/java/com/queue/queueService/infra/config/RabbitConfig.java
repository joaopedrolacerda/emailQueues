package com.queue.queueService.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue emailQueue(){
        return new Queue("emailData", false);
    }
}
