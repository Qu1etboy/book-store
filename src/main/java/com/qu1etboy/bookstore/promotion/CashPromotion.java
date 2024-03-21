package com.qu1etboy.bookstore.promotion;

import lombok.Data;

@Data
public class CashPromotion implements Promotion {

    private double discount;

    public CashPromotion(double discount) {
        this.discount = discount;
    }

    @Override
    public double discount(double price) {
        return discount;
    }
}
