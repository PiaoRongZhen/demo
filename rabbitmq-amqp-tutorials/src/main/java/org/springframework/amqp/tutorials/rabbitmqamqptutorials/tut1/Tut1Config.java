package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut1Config {

    @Bean
    public Queue hello1_1() {
        return new Queue("hello1_1");
    }

    @Bean
    public Tut1Receiver receiver1_1() {
        return new Tut1Receiver();
    }

}
