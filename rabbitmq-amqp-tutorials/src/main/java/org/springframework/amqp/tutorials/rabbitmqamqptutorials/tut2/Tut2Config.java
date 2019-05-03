package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut2Config {

    @Bean
    public Queue hello2_1() {
        return new Queue("hello2_1");
    }

    @Bean
    public Tut2Receiver receiver2_1() {
        return new Tut2Receiver(1);
    }

    @Bean
    public Tut2Receiver receiver2_2() {
        return new Tut2Receiver(2);
    }

}
