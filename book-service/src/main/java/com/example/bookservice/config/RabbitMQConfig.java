package com.example.bookservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String STRING_QUEUE = "stringQueue";
    public static final String OBJECT_QUEUE = "objectQueue";
    public static final String EXCHANGE = "bookExchange";

    @Bean
    public Queue stringQueue() {
        return new Queue(STRING_QUEUE, false);
    }

    @Bean
    public Queue objectQueue() {
        return new Queue(OBJECT_QUEUE, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding stringBinding(Queue stringQueue, TopicExchange exchange) {
        return BindingBuilder.bind(stringQueue).to(exchange).with("book.string");
    }

    @Bean
    public Binding objectBinding(Queue objectQueue, TopicExchange exchange) {
        return BindingBuilder.bind(objectQueue).to(exchange).with("book.object");
    }
}
