package com.example.bookservice.controller;

import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.service.BookService;
import com.example.bookservice.messaging.BookMessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;
    private final BookMessageProducer bookMessageProducer;

    public BookController(BookService service, BookMessageProducer bookMessageProducer) {
        this.service = service;
        this.bookMessageProducer = bookMessageProducer;
    }

    @GetMapping
    public List<BookDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BookDTO save(@RequestBody BookDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/send-string")
    public ResponseEntity<String> sendString() {
        bookMessageProducer.sendStringMessage("Hello from book-service!");
        return ResponseEntity.ok("String message sent!");
    }

    @GetMapping("/send-object")
    public ResponseEntity<String> sendBook() {
        BookDTO book = new BookDTO(1L, "Async Rabbit", "Spring Rabbit Author");
        bookMessageProducer.sendObjectMessage(book);
        return ResponseEntity.ok("Book object sent!");
    }
}
