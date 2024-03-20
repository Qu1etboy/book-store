package com.qu1etboy.bookstore.promotion;

import lombok.Data;

@Data
public class PercentPromotion implements Promotion {
    /**
     * The percent discount to apply to the price (e.g. 0.1 for 10% off)
     */
    private double percent;

    public PercentPromotion(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        return price - price * percent;
    }
}
