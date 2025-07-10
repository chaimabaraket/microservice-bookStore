package com.example.bookservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bookservice.dto.StockDTO;

import java.util.List;

@FeignClient(name = "stock-service", url = "http://localhost:8081", fallback = StockClientFallback.class)
public interface StockClient {
    @GetMapping("/stocks/details")
    List<StockDTO> getStockDetails();
}

