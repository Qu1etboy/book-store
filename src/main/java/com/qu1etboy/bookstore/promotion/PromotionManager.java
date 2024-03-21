package com.qu1etboy.bookstore.promotion;

import java.util.List;

public class PromotionManager {

    public double getTotalDiscount(List<Promotion> promotions, double price) {
        double totalDiscount = 0;
        for (Promotion promotion : promotions) {
            if (promotion == null) {
                continue;
            }
            totalDiscount += promotion.discount(price);
        }
        return totalDiscount;
    }

    public double apply(List<Promotion> promotions, double price) {
        return price - getTotalDiscount(promotions, price);
    }
}
