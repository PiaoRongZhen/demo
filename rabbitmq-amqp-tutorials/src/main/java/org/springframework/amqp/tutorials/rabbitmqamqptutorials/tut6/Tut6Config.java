package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut6;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut6Config {

    @Bean
    public DirectExchange exchange6_1() {
        return new DirectExchange("tut.rpc");
    }

    @Bean
    public Queue queue6_1() {
        return new Queue("tut.rpc.requests");
    }

    @Bean
    public Binding binding6_1(DirectExchange exchange6_1, Queue queue6_1) {
        return BindingBuilder.bind(queue6_1).to(exchange6_1).with("rpc");
    }

    @Bean
    public Tut6Server server6() {
        return new Tut6Server();
    }
}
