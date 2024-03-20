package com.qu1etboy.bookstore.book;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(BookRequest request) {
        Book book = modelMapper.map(request, Book.class);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, BookRequest request) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            modelMapper.map(request, book);
            return bookRepository.save(book);
        }
        return null;
    }
}
