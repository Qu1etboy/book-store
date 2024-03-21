package com.qu1etboy.bookstore.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qu1etboy.bookstore.promotion.Promotion;
import com.qu1etboy.bookstore.promotion.PromotionCatalog;
import com.qu1etboy.bookstore.promotion.PromotionManager;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Cashier implements Serializable {

    private PurchaseOrder order;

    @JsonIgnore
    private PromotionCatalog promotionCatalog;

    private double totalPrice;
    private double totalPriceWithDiscount;

    public Cashier(PurchaseOrder order, PromotionCatalog promotionCatalog) {
        this.order = order;
        this.promotionCatalog = promotionCatalog;
        this.totalPrice = getTotalPrice();
        this.totalPriceWithDiscount = getTotalPriceWithDiscount();
    }

    /**
     * Calculate the total price of the order without any discounts
     *
     * @return the total price of the order
     */
    public double getTotalPrice() {
        double total = 0;

        for (OrderItem orderItem : order.getOrderItems()) {
            total += orderItem.getTotalPrice();
        }

        return total;
    }

    /**
     * Calculate the total price of the order with the applied discounts
     * <p>
     * If no promotion codes are applied, the total price is returned
     *
     * @return the total price of the order with the applied discounts
     */
    public double getTotalPriceWithDiscount() {
        double total = getTotalPrice();
        List<Promotion> promotions = order.getPromotionCodes().stream()
                .map(promotionCatalog::get)
                .toList();

        return new PromotionManager().apply(promotions, total);
    }

    public double getTotalDiscount() {
        double total = getTotalPrice();
        List<Promotion> promotions = order.getPromotionCodes().stream()
                .map(promotionCatalog::get)
                .toList();

        return new PromotionManager().getTotalDiscount(promotions, total);
    }
}
