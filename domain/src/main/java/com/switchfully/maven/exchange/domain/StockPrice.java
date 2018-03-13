package com.switchfully.maven.exchange.domain;

import java.math.BigDecimal;

/**
 * StockPrice is what we call a value object.
 * - It describes a concept (the price of a stock)
 * - It really doesn't have any unique-ability
 *      - If I need a price of €10, and I have 2 instances available that hold that value, does it really matter which instance I get (the answer is no)?
 *      - If I need person , and I have 2 instances of Keanu Reeves, does it really matter which instance I get
 *        (the answer is yes, since they're both unique: one is the famous actor, one is just 'a guy').
 * - Because it has no concept of 'uniqueness' it can be immutable: once initialized, the state can never change.
 *      - We do this by making the class final, and all of its properties (instance variables)
 *      - All methods will be have to be pure methods!
 *
 * If a Stock needs a updated price, we'll simply give him a new StockPrice
 */
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
