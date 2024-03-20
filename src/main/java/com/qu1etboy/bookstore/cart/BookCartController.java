package com.qu1etboy.bookstore.cart;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class BookCartController {
    @Autowired
    private BookCartService bookCartService;

    @PostMapping
    public void addBookToCart(@Valid @NotEmpty @RequestBody List<BookOrderRequest> bookOrders) {
        bookCartService.addBookToCart(bookOrders);
    }
}
