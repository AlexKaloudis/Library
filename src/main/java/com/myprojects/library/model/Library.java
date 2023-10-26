package com.myprojects.library.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Library {
    @Id
    private String id;
    private String name;
    private List<String> memberIds;
    private List<String> bookIds;

    
    public Library() {
    }

    public Library(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Library(String id, String name,List<String> memberIds,List<String> bookIds) {
        this.id = id;
        this.name = name;
        this.memberIds = memberIds;
        this.bookIds = bookIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

//    public void borrowBook(@NotNull Member member, @NotNull Book book){
//
//        MemberBooks memberBooksObj = new MemberBooks(member.getFirstName(), member.getLastName(), book.getTitle(),LocalDate.now().plusDays(30) );
//        if(!membersBooks.contains(memberBooksObj)){
//            membersBooks.add(memberBooksObj);
//        }
//        else{
//            System.out.println("the book is already borrowed by some other member");
//        }
//    }

}
