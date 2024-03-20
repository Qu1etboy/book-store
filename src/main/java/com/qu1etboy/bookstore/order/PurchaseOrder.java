package com.qu1etboy.bookstore.order;

import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    private OrderStatus status;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public PurchaseOrder() {
        orderItems = new ArrayList<>();
        status = OrderStatus.PENDING;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

}
