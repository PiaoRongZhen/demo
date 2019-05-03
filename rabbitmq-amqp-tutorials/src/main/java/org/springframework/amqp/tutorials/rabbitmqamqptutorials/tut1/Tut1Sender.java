package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tut1Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("hello1_1")
    private Queue queue;

    @GetMapping("/send1")
    public String send() {

        String message = "Hello World!";

        template.convertAndSend(queue.getName(), message);

        return "ok";
    }

}
