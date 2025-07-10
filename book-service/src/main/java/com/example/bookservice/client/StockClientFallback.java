package com.example.bookservice.client;

import com.example.bookservice.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class StockClientFallback implements StockClient {
    @Override
    public List<StockDTO> getStockDetails() {
        System.out.println("✅ Fallback activé !");
        return Collections.emptyList();
    }
}

