package com.example.bookservice.messaging;

import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public BookMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendStringMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "book.string", message);
    }

    public void sendObjectMessage(BookDTO book) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "book.object", book);
    }
}
