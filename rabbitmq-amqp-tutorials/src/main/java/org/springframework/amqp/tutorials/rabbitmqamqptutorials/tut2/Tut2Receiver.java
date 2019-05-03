package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello2_1")
public class Tut2Receiver {

    private final int instance;

    public Tut2Receiver(int i) {
        this.instance = i;
    }

    @RabbitHandler
    public void receive(String in) {

        System.out.println("instance " + this.instance + " [x] Received '" + in + "'");

    }

}
