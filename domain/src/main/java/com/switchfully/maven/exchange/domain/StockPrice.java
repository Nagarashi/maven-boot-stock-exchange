package com.switchfully.maven.exchange.domain;

import java.math.BigDecimal;

public final class StockPrice {

    private final BigDecimal price;
    private final StockCurrency currency;

    public StockPrice(BigDecimal price, StockCurrency currency) {
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public StockCurrency getCurrency() {
        return currency;
    }
}
