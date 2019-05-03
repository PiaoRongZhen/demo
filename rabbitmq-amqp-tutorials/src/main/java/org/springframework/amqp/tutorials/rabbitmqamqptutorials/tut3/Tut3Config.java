package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut3;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Tut3Config {

    @Bean
    public FanoutExchange fanout3_1() {
        return new FanoutExchange("tut.fanout");
    }

    @Bean
    public Queue autoDeleteQueue3_1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue3_2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding3_1(FanoutExchange fanout3_1, Queue autoDeleteQueue3_1) {
        return BindingBuilder.bind(autoDeleteQueue3_1).to(fanout3_1);
    }

    @Bean
    public Binding binding3_2(FanoutExchange fanout3_1, Queue autoDeleteQueue3_2) {
        return BindingBuilder.bind(autoDeleteQueue3_2).to(fanout3_1);
    }

    @Bean
    public Tut3Receiver receiver3_1() {
        return new Tut3Receiver();
    }

}
