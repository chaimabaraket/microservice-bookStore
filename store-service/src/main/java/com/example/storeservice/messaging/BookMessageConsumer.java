package com.example.storeservice.messaging;

import com.example.storeservice.dto.BookDTO;
import com.example.storeservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookMessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.STRING_QUEUE)
    public void receiveStringMessage(String message) {
        System.out.println("📥 Received string message: " + message);
    }

    @RabbitListener(queues = RabbitMQConfig.OBJECT_QUEUE)
    public void receiveObjectMessage(BookDTO book) {
        System.out.println("📥 Received book object: " + book.getTitle() + " by " + book.getAuthor());
    }
}
