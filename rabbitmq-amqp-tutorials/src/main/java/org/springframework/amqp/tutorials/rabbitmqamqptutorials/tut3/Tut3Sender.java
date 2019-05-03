package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut3;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tut3Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("fanout3_1")
    private FanoutExchange fanout;


    @GetMapping("/send3")
    public String send() {

        String message = "Hello World!";

        template.convertAndSend(fanout.getName(), "", message);

        return "ok";
    }

}
