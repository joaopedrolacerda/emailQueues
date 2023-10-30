package com.queue.queueService.controllers;

import com.queue.queueService.useCases.QueueUseCase;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.queue.queueService.infra.config.RabbitConfig;

@RestController
@RequestMapping("/requests")
public class ReceiveDataController {

    private final  QueueUseCase queueUseCase;




    public ReceiveDataController(QueueUseCase queueUseCase) {
        this.queueUseCase = queueUseCase;
    }

    @PostMapping
    public String receivesAndQueueRequest(@RequestBody String requestData){

        queueUseCase.sendMessagetToQueue("emailData", requestData);
        queueUseCase.receiveMessageFromQueue("emailData");
        return "request received and queued" + requestData;
    }
}
