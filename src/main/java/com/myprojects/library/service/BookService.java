package com.myprojects.library.service;

import com.myprojects.library.model.Book;
import com.myprojects.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.insert(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
