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

    private String hour;

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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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





