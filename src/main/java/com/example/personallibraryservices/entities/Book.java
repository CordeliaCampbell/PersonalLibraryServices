package com.example.personallibraryservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)     //Primary key for entitiy
    Long id = 0L;
    String title = "";
    String author = "";
    String isbn = "";
    String localDate = "";

    //Default constructor
    public Book(){

    }

    //Constructor
    public Book(String title, String author, String isbn, String localDate, Long id){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.localDate = localDate;
        this.id = id;
    }

    //Getters and Setters
    public void setId(Long id) {this.id = id;}
    public Long getId() {
        return this.id;
    }

    public void setTitle(String title){this.title = title;}
    public String getTitle() {return this.title;}

    public void setAuthor(String author){this.author = author;}
    public String getAuthor() {return this.author;}

    public void setIsbn(String isbn){this.isbn = isbn;}
    public String getIsbn() {return this.isbn;}

    public void setLocalDate(String localDate){this.localDate = localDate;}
    public String getLocalDate() {return this.localDate;}

    //Equals method that will work for this object
    @Override
    public boolean equals(Object obj){
        if(this == obj) {return true;}
        if(obj == null || getClass() != obj.getClass()) {return false;}
        Book book = (Book) obj;
        return
                Objects.equals(id, book.id) &&
                        Objects.equals(title, book.title) &&
                        Objects.equals(author, book.author) &&
                        Objects.equals(isbn, book.isbn) &&
                        Objects.equals(localDate, book.localDate);
    }

    //Make something that can produce hash code for this object
    @Override
    public int hashCode(){
        return Objects.hash(id, title, author, isbn, localDate);
    }

    //Make a toString method for this object
    @Override
    public String toString(){
        return "Book{" +
                "id = " + id +
                "title = " + title +
                "author = " + author +
                "isbn = " + isbn +
                "localDate = " + localDate +
                '}';
    }
}
