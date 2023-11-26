package com.myprojects.library.service;

import com.myprojects.library.model.Book;
import com.myprojects.library.model.Library;
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
    public void addListOfBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book GetBook(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book UpdateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String bookId) {
       bookRepository.deleteById(bookId);
    }
}
