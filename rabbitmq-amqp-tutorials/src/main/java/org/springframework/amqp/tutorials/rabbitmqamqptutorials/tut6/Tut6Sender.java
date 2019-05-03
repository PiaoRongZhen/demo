package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut6;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tut6Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("exchange6_1")
    private DirectExchange exchange;

    @GetMapping("/send6")
    public String send() {

        Integer response = (Integer) template.convertSendAndReceive(exchange.getName(), "rpc", 20);

        return response.toString();

    }


}
