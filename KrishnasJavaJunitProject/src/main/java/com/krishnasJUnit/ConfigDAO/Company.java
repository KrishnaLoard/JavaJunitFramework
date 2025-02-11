package com.krishnasJUnit.ConfigDAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {
    private String name;
    private String symbol;

    @JsonProperty("has_intraday")
    private boolean hasIntraday;

    @JsonProperty("has_eod")
    private boolean hasEod;
    private String country;

    @JsonProperty("stock_exchange")
    private StockExchange stockExchange;

    public Company() {

    }

    public Company(String name, String symbol, boolean hasIntraday, boolean hasEod, String country, StockExchange stockExchange) {
        this.name = name;
        this.symbol = symbol;
        this.hasIntraday = hasIntraday;
        this.hasEod = hasEod;
        this.country = country;
        this.stockExchange = stockExchange;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isHasIntraday() {
        return hasIntraday;
    }

    public void setHasIntraday(boolean hasIntraday) {
        this.hasIntraday = hasIntraday;
    }

    public boolean isHasEod() {
        return hasEod;
    }

    public void setHasEod(boolean hasEod) {
        this.hasEod = hasEod;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
