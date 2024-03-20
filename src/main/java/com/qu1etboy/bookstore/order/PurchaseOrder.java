package com.qu1etboy.bookstore.order;

import com.qu1etboy.bookstore.promotion.Promotion;
import com.qu1etboy.bookstore.promotion.PromotionCatalog;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> promotionCodes;

    private OrderStatus status;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public PurchaseOrder() {
        orderItems = new ArrayList<>();
        status = OrderStatus.PENDING;
        promotionCodes = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void addPromotionCode(String code) {
        promotionCodes.add(code);
    }

}
