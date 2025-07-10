package com.example.bookservice.service;

import com.example.bookservice.client.StockClient;
import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.dto.StockDTO;
import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;
    private final StockClient stockClient;

    public BookService(BookRepository repository, BookMapper mapper, StockClient stockClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.stockClient = stockClient;
    }

    public List<BookDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public BookDTO save(BookDTO dto) {
        Book book = mapper.toEntity(dto);
        Book saved = repository.save(book);
        return mapper.toDto(saved);
    }

    public BookDTO getById(Long id) {
        Optional<Book> optional = repository.findById(id);
        return optional.map(mapper::toDto).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

  public List<StockDTO> callStockService() {
    return stockClient.getStockDetails(); // java.util.List now!
}


}
