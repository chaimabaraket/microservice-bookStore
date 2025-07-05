package com.example.bookservice.dto;

import java.time.LocalDate;

public class BookDTO {
    private Long id;
    private String name;
    private String writer;
    private LocalDate publishedDate;

    public BookDTO(long l, String string, String string2) {
        //TODO Auto-generated constructor stub
    }
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }
}