package com.qu1etboy.bookstore.cart;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("bookCartList")
public class BookCartList implements BookCart {
    private List<BookOrderRequest> bookOrderList;

    @Override
    public List<BookOrderRequest> getBookOrders() {
        return bookOrderList;
    }

    @Override
    public void setBookOrders(List<BookOrderRequest> bookOrders) {
        this.bookOrderList = bookOrders;
    }
}
