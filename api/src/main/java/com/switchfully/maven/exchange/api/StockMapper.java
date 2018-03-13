package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;

import java.math.BigDecimal;

public class StockMapper {

    public StockDto mapToDto(Stock stock) {
        return new StockDto(
                stock.getId(),
                stock.getName(),
                stock.getPrice() != null ? stock.getPrice().getPrice() : new BigDecimal(0),
                stock.getPrice() != null ? stock.getPrice().getCurrency().getLabel() : "Unknown");
    }
}
