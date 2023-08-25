package com.myprojects.library.model;

import java.time.LocalDate;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

public class Library {
    @Id
    private String id;
    private List<MemberBooks> membersBooks;

    public Library(String id, List<MemberBooks> membersBooks) {
        this.id = id;
        this.membersBooks = membersBooks;
    }

    public void borrowBook(@NotNull Member member, @NotNull Book book){

        MemberBooks memberBooksObj = new MemberBooks(member.getFirstName(), member.getLastName(), book.getTitle(),LocalDate.now().plusDays(30) );
        if(!membersBooks.contains(memberBooksObj)){
            membersBooks.add(memberBooksObj);
        }
        else{
            System.out.println("the book is already borrowed by some other member");
        }
    }

}
