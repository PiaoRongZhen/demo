package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut5;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange topic5_1() {
        return new TopicExchange("tut.topic");
    }

    @Bean
    public Tut5Receiver receiver5_1() {
        return new Tut5Receiver();
    }

    @Bean
    public Queue autoDeleteQueue5_1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue5_2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1a_5(TopicExchange topic5_1, Queue autoDeleteQueue5_1) {
        return BindingBuilder.bind(autoDeleteQueue5_1).to(topic5_1).with("*.orange.*");
    }

    @Bean
    public Binding binding1b_5(TopicExchange topic5_1, Queue autoDeleteQueue5_2) {
        return BindingBuilder.bind(autoDeleteQueue5_2).to(topic5_1).with("*.*.rabbit");
    }

    @Bean
    public Binding binding2a_5(TopicExchange topic5_1, Queue autoDeleteQueue5_2) {
        return BindingBuilder.bind(autoDeleteQueue5_2).to(topic5_1).with("lazy.#");
    }


}
