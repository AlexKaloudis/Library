package com.myprojects.library.service;
import com.myprojects.library.model.MemberBooks;
import com.myprojects.library.repository.MemberBooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberBooksService {
    private MemberBooksRepository memberBooksRepository;

    public MemberBooksService(MemberBooksRepository memberBooksRepository) {
        this.memberBooksRepository = memberBooksRepository;
    }

//    public void addBook(Book book) {
//        bookRepository.insert(book);
//    }

    public List<MemberBooks> getAllMemberBooksInfo() {
        return memberBooksRepository.findAll();
    }
}
