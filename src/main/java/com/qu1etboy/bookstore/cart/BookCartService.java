package com.qu1etboy.bookstore.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCartService {

    @Autowired
    @Qualifier("bookCartList")
    private BookCart bookCart;

    public void addBookToCart(List<BookOrderRequest> bookOrders) {
        bookCart.setBookOrders(bookOrders);
    }

    public List<BookOrderRequest> getBookOrders() {
        return bookCart.getBookOrders();
    }
}
