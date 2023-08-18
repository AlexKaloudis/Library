package com.myprojects.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myprojects.library.model.Library;

public interface LibraryRepository extends MongoRepository<Library, String>{
    
}
