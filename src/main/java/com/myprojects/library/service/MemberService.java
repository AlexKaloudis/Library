package com.myprojects.library.service;

import com.myprojects.library.model.Book;
import com.myprojects.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private BookRepository bookRepository;

    public MemberService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.insert(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
