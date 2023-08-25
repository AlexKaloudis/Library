package com.myprojects.library.model;

import java.time.LocalDate;

public class MemberBooks {

    private String MemberFirstName;
    private String MemberLastName;
    private String BookTitle;
    private LocalDate DueDate;

    public MemberBooks(String memberFirstName, String memberLastName, String bookTitle, LocalDate dueDate) {
        MemberFirstName = memberFirstName;
        MemberLastName = memberLastName;
        BookTitle = bookTitle;
        DueDate = dueDate;
    }
}
