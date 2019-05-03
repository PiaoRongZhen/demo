package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut4;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;


    @Autowired
    @Qualifier("direct4_1")
    private DirectExchange direct;

    @GetMapping("/send4_1")
    public String send1() {

        String message = "Hello to orange";

        template.convertAndSend(direct.getName(), "orange", message);

        return "ok";
    }

    @GetMapping("/send4_2")
    public String send2() {

        String message = "Hello to black";

        template.convertAndSend(direct.getName(), "black", message);

        return "ok";
    }

    @GetMapping("/send4_3")
    public String send3() {

        String message = "Hello to green";

        template.convertAndSend(direct.getName(), "green", message);

        return "ok";
    }




}
