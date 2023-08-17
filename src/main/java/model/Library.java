package model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Library {
    @Id
    private String id;
    private String name;
    private List<Book> books;
    public Library(String id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
}
