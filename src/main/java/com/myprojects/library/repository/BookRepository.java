package com.myprojects.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myprojects.library.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    
}
