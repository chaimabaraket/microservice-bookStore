package com.example.storeservice.service;

import com.example.storeservice.dto.StockDTO;
import com.example.storeservice.mapper.StockMapper;
import com.example.storeservice.model.Stock;
import com.example.storeservice.repository.StockRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository repository;
    private final StockMapper mapper;
    private final RestTemplate restTemplate;

    @Value("${book.service.url:http://book-service/books}")
    private String bookServiceUrl;

    public StockService(StockRepository repository, StockMapper mapper, RestTemplate restTemplate) {
        this.repository = repository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    public List<StockDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public StockDTO save(StockDTO dto) {
        Stock entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    @CircuitBreaker(name = "bookServiceCB", fallbackMethod = "fallbackBookDetails")
    public List<StockDTO> getAllWithBookDetails() {
        return repository.findAll().stream().map(stock -> {
            StockDTO dto = mapper.toDto(stock);
            try {
                Object book = restTemplate.getForObject(bookServiceUrl + "/" + stock.getBookId(), Object.class);
                System.out.println("Book Info: " + book);
            } catch (Exception ex) {
                System.out.println("Book service unavailable.");
            }
            return dto;
        }).collect(Collectors.toList());
    }

    public List<StockDTO> fallbackBookDetails(Throwable t) {
        return getAll();
    }
}