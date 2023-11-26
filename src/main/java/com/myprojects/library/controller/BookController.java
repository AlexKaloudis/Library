package com.myprojects.library.controller;

import com.myprojects.library.model.Book;
import com.myprojects.library.model.Library;
import com.myprojects.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

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

    @GetMapping("{id}")
    public Book GetBook(@PathVariable String id) {
        return bookService.GetBook(id);
    }

    @PutMapping
    public ResponseEntity<Book> UpdateBook(@RequestBody Book book) {
        return ok(bookService.UpdateBook(book));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void AddMultipleBooks(@RequestBody List<Book> books) {
        bookService.addListOfBooks(books);
    }
    @DeleteMapping("{bookId}")
    public void DeleteBook(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
    }
}
