package com.qu1etboy.bookstore.book;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BookRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Publisher is required")
    private String publisher;

    @NotNull(message = "Published date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;

    @Min(value = 0, message = "Price should not be less than 0")
    @Max(value = 1000, message = "Price should not be greater than 1000")
    private double price;
}
