package com.switchfully.maven.exchange.api;

import java.math.BigDecimal;

public class StockDto {

    private String id;
    private String name;
    private BigDecimal price;
    private String currency;

    StockDto(String id, String name, BigDecimal price, String currency) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
