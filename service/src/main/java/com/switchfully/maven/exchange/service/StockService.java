package com.switchfully.maven.exchange.service;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.domain.StockCurrency;
import com.switchfully.maven.exchange.domain.StockPrice;
import com.switchfully.maven.exchange.domain.StockRepository;
import com.switchfully.maven.exchange.interfaces.ExternalStockInformationService;

import java.math.BigDecimal;

public class StockService {

    public Stock getStock(String stockId) {
        try {
            Stock stockWithoutPrice = StockRepository.getStockInformation(stockId);
            return enrichtStockWithPrice(stockWithoutPrice);
        } catch (IllegalArgumentException e) {
            return new Stock(stockId, "Unknown stock");
        }
    }

    private Stock enrichtStockWithPrice(Stock stock) {
        BigDecimal priceInEuroForStock = ExternalStockInformationService
                .getPriceInEuroForStock(stock.getId());
        stock.setPrice(new StockPrice(priceInEuroForStock, StockCurrency.EUR));
        return stock;
    }
}
