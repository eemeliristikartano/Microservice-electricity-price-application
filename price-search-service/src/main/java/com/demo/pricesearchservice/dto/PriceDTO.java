package com.demo.pricesearchservice.dto;

public class PriceDTO {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "price=" + price +
                '}';
    }
}
