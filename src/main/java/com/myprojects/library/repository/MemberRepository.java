package com.myprojects.library.repository;

import com.myprojects.library.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
    
}
