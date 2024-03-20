package com.qu1etboy.bookstore.promotion;

public class PromotionFactory {

    public static Promotion createPromotion(String type, double value) {
        return switch (type) {
            case "percent" -> new PercentPromotion(value);
            case "cash" -> new CashPromotion(value);
            default -> throw new IllegalArgumentException("Unknown promotion type: " + type);
        };
    }
}
