package com.qu1etboy.bookstore.order;

import com.qu1etboy.bookstore.book.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private Date bookPublishedDate;

    private int quantity;
    private double price;

    public double getTotalPrice() {
        return price * quantity;
    }

    public void setBook(Book book) {
        this.bookId = book.getId();
        this.bookName = book.getName();
        this.bookAuthor = book.getAuthor();
        this.bookPublisher = book.getPublisher();
        this.bookPublishedDate = book.getPublishedDate();
        this.price = book.getPrice();
    }
}
