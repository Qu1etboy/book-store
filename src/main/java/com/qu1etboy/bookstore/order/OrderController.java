package com.qu1etboy.bookstore.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<PurchaseOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public PurchaseOrder createOrUpdateOrder() {
        return orderService.createOrUpdateOrder();
    }

    @PostMapping("/pay")
    public boolean payOrder() {
        orderService.payOrder();
        return true;
    }

    @DeleteMapping
    public void deleteOrders() {
        orderService.deleteOrders();
    }
}