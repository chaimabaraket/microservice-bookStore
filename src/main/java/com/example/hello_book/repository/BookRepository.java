package com.example.hello_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello_book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
