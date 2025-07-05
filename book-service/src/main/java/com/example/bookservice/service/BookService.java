package com.example.bookservice.service;

import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repo;
    private final BookMapper mapper;

    public BookService(BookRepository repo, BookMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<BookDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public BookDTO save(BookDTO dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public BookDTO getById(Long id) {
        return repo.findById(id).map(mapper::toDto).orElseThrow();
    }
}