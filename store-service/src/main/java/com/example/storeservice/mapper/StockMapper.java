package com.example.storeservice.mapper;

import com.example.storeservice.dto.StockDTO;
import com.example.storeservice.model.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {
    public StockDTO toDto(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setBookId(stock.getBookId());
        dto.setQuantity(stock.getQuantity());
        return dto;
    }

    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setBookId(dto.getBookId());
        stock.setQuantity(dto.getQuantity());
        return stock;
    }
}