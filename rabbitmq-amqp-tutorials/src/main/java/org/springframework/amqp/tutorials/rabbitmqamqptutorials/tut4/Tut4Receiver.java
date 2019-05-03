package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut4;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut4Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue4_1.name}")
    public void receive1(String in) {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue4_2.name}")
    public void receive2(String in) {
        receive(in, 2);
    }

    public void receive(String in, int receiver) {

        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
    }

}
