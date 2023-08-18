package com.demo.pricetodayandtomorrowservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceDTO {

    @JsonProperty("Rank")
    private int rank;

    @JsonProperty("DateTime")
    private String dateTime;

    @JsonProperty("PriceNoTax")
    private double priceNoTax;

    @JsonProperty("PriceWithTax")
    private double priceWithTax;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getPriceNoTax() {
        return priceNoTax;
    }

    public void setPriceNoTax(double priceNoTax) {
        this.priceNoTax = priceNoTax;
    }

    public double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    @Override
    public String toString() {
        return "Price{" +
                "Rank=" + rank +
                ", DateTime='" + dateTime + '\'' +
                ", PriceNoTax=" + priceNoTax +
                ", priceWithTax=" + priceWithTax +
                '}';
    }
}





