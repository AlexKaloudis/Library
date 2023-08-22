package com.myprojects.library.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Document
public class Book {
    @Id
    private String id;

    @Indexed(unique = true)
    private String title;

    private int pages;
    public Book() {
    }
    
    public Book(String title, String id, int pages) {
        this.title = title;
        this.id = id;
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    
}
