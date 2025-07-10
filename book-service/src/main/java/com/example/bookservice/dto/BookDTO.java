package com.example.bookservice.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BookDTO implements Serializable {
    private Long id;
    private String name;
    private String writer;
    private LocalDate publishedDate;

    public BookDTO() {} // ✅ Default constructor

    public BookDTO(Long id, String name, String writer) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.publishedDate = LocalDate.now(); // optional
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
