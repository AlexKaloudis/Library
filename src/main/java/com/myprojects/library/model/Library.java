package com.myprojects.library.model;

import java.util.List;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document("libraries")
@Data
public class Library {
    @Id
    private String id;
    private String name;
    @DocumentReference(lazy=true)
    private List<Member> members;
    @DocumentReference(lazy=true)
    private List<Book> books;

    
    public Library() {
    }

    public Library(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Library(String id, String name,List<Member> members,List<Book> books) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.books = books;
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
