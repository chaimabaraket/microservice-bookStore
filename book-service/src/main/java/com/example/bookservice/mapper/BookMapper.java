package com.example.bookservice.mapper;

import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDTO toDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setWriter(book.getWriter());
        dto.setPublishedDate(book.getPublishedDate());
        return dto;
    }

    public Book toEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setWriter(dto.getWriter());
        book.setPublishedDate(dto.getPublishedDate());
        return book;
    }
}