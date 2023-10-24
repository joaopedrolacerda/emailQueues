package com.queue.queueService.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class ReceiveDataController {
    private final RabbitTemplate rabbitTemplate;

    public ReceiveDataController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public String receivesAndQueueRequest(@RequestBody String requestData){
        rabbitTemplate.convertAndSend("emailData", requestData );
        return "request received and queued" + requestData;
    }
}
