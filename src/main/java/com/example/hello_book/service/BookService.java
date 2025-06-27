package com.example.hello_book.service;

import org.springframework.stereotype.Service;

import com.example.hello_book.model.Book;
import com.example.hello_book.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) { this.repo = repo; }

    public List<Book> findAll() { return repo.findAll(); }
    public Book save(Book b)     { return repo.save(b); }
    // ajoutez update/delete si besoin
}
