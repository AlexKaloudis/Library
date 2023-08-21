package com.myprojects.library.controller;

import com.myprojects.library.model.Book;
import com.myprojects.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> GetBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void AddLibrary(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
