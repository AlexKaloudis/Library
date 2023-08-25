package com.myprojects.library.model;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Member {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<Book> borrowedBooks;

    @Column(unique = true)
    private String email;

    public Member(String id, String firstName, String lastName, String email,List<Book> borrowedBooks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrowedBooks = borrowedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}
