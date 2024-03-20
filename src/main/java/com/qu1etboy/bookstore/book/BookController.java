package com.qu1etboy.bookstore.book;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody BookRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        return bookService.updateBook(id, request);
    }

}
