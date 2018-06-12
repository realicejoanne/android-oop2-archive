package com.trianne.currencyconverter;

/**
 * Created by HP on 17/04/2018.
 */

public class Conversion {
    Keys keys;

    /**
     * The equivalent to 1 USD
     */
    private final double RP = 14000.0;
    private final double USD = 1.0;
    private final double EURO = 0.8;
    private final double YEN = 107.0;

    private double inputCurrency;
    private double currencyInUSD;
    private String baseCurrency;

    public Conversion(String baseCurrency, double inputCurrency) {
        this.baseCurrency = baseCurrency;
        this.inputCurrency = inputCurrency;
        convertTo();
    }

    private void convertTo() {
        if (this.baseCurrency == keys.RUPIAH) {
            this.currencyInUSD = inputCurrency / this.RP;
        } else if (this.baseCurrency == keys.USD) {
            this.currencyInUSD = inputCurrency / this.USD;
        } else if (this.baseCurrency == keys.YEN) {
            this.currencyInUSD = inputCurrency / this.YEN;
        } else if (this.baseCurrency == keys.EURO) {
            this.currencyInUSD = inputCurrency / this.EURO;
        }
    }

    public double getRupiah() {
        return this.currencyInUSD * this.RP;
    }

    public double getUsd() {
        return this.currencyInUSD * this.USD;
    }

    public double getYen() {
        return this.currencyInUSD * this.YEN;
    }

    public double getEuro() {
        return this.currencyInUSD * this.EURO;
    }
}

