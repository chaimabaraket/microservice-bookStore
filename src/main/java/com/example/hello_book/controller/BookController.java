package com.example.hello_book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello_book.model.Book;
import com.example.hello_book.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService service;
  public BookController(BookService service) { this.service = service; }

  @GetMapping
  public List<Book> list() {
    return service.findAll();
  }

  @PostMapping
  public Book create(@RequestBody Book b) {
    return service.save(b);
  }
}

