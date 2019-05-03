package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut4;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut4Config {

    @Bean
    public DirectExchange direct4_1() {
        return new DirectExchange("tut.direct");
    }

    @Bean
    public Queue autoDeleteQueue4_1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue4_2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding4_1a(DirectExchange direct4_1, Queue autoDeleteQueue4_1) {
        return BindingBuilder.bind(autoDeleteQueue4_1).to(direct4_1).with("orange");
    }

    @Bean
    public Binding binding4_1b(DirectExchange direct4_1, Queue autoDeleteQueue4_1) {
        return BindingBuilder.bind(autoDeleteQueue4_1).to(direct4_1).with("black");
    }

    @Bean
    public Binding binding4_2a(DirectExchange direct4_1, Queue autoDeleteQueue4_2) {
        return BindingBuilder.bind(autoDeleteQueue4_2).to(direct4_1).with("green");
    }

    @Bean
    public Binding binding4_2b(DirectExchange direct4_1, Queue autoDeleteQueue4_2) {
        return BindingBuilder.bind(autoDeleteQueue4_2).to(direct4_1).with("black");
    }

    @Bean
    public Tut4Receiver receiver4_1() {
        return new Tut4Receiver();
    }

}
