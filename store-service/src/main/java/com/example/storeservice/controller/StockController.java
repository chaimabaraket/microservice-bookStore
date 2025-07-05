package com.example.storeservice.controller;

import com.example.storeservice.dto.StockDTO;
import com.example.storeservice.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @GetMapping
    public List<StockDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/details")
    public List<StockDTO> getAllWithBook() {
        return service.getAllWithBookDetails();
    }

    @PostMapping
    public StockDTO save(@RequestBody StockDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}