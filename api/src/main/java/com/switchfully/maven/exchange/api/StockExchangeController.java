package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.service.StockService;

public class StockExchangeController {

    private StockService stockService;
    private StockMapper stockMapper;

    public StockExchangeController(StockService stockService, StockMapper stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    /**
     * For your information:
     * This method gets called from outside this application
     * (not really, but just imagine it will)
     */
    public StockDto getStock(String stockId) {
        Stock foundStock = stockService.getStock(stockId);
        return stockMapper.mapToDto(foundStock);
    }

}
