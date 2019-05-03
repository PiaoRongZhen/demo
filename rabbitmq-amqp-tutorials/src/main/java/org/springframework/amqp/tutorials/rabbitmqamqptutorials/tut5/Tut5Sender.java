package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tut5Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic5_1;

    @GetMapping("/send5_1")
    public String send1() {

        String message = "Hello to quick.orange.rabbit";

        template.convertAndSend(topic5_1.getName(), "quick.orange.rabbit", message);

        return "ok";
    }

    @GetMapping("/send5_2")
    public String send2() {

        String message = "Hello to lazy.orange.elephant";

        template.convertAndSend(topic5_1.getName(), "lazy.orange.elephant", message);

        return "ok";
    }

    @GetMapping("/send5_3")
    public String send3() {

        String message = "Hello to quick.orange.fox";

        template.convertAndSend(topic5_1.getName(), "quick.orange.fox", message);

        return "ok";
    }


    @GetMapping("/send5_4")
    public String send4() {

        String message = "Hello to lazy.brown.fox";

        template.convertAndSend(topic5_1.getName(), "lazy.brown.fox", message);

        return "ok";
    }

    @GetMapping("/send5_5")
    public String send5() {

        String message = "Hello to lazy.pink.rabbit";

        template.convertAndSend(topic5_1.getName(), "lazy.pink.rabbit", message);

        return "ok";
    }

    @GetMapping("/send5_6")
    public String send6() {

        String message = "Hello to quick.brown.fox";

        template.convertAndSend(topic5_1.getName(), "quick.brown.fox", message);

        return "ok";
    }

}
