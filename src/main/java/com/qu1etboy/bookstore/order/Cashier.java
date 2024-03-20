package com.qu1etboy.bookstore.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qu1etboy.bookstore.promotion.Promotion;
import com.qu1etboy.bookstore.promotion.PromotionCatalog;
import lombok.Data;

import java.io.Serializable;

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
        for (String code : order.getPromotionCodes()) {
            Promotion promotion = promotionCatalog.get(code);
            if (promotion == null) {
                continue;
            }
            total = promotion.apply(total);
        }

        return total;
    }

//    public double checkout(ShoppingCart cart) {
//        double total = cart.getTotal();
//        for (String promotion : cart.getPromotions()) {
//            total = promotionCatalog.get(promotion).apply(total);
//        }
//        return total;
//    }
}
