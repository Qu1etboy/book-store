package com.qu1etboy.bookstore.cart;

import org.springframework.stereotype.Component;

import java.util.List;

public interface BookCart {

    List<BookOrderRequest> getBookOrders();

    void setBookOrders(List<BookOrderRequest> bookOrders);
}
