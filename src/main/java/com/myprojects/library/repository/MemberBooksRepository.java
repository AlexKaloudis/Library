package com.myprojects.library.repository;

import com.myprojects.library.model.MemberBooks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberBooksRepository extends MongoRepository<MemberBooks, String> {
    
}
