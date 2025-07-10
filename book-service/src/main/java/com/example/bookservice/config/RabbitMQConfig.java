package com.example.bookservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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

    // ✅ Jackson converter with LocalDate support
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(mapper);
    }

    // ✅ RabbitTemplate with converter injected
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        return template;
    }
}
