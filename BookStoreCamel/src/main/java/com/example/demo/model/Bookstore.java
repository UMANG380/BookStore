package com.example.demo.model;

import org.springframework.stereotype.Component;
import java.util.Objects;

/*
 * Author: Umang Agarwal
 * Description: Bookstore Model
 * Created On: 30/04/2020
 */

@Component
public class Bookstore {
    int isbn;
    String title;
    String author;
    String Publisher;

    public Bookstore() {
    }

    public Bookstore(int isbn, String title, String author, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        Publisher = publisher;
    }

    public int getIsbn() { return isbn; }

    public void setIsbn(int isbn) { this.isbn = isbn; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookstore bookStore = (Bookstore) o;
        return isbn == bookStore.isbn &&
                Objects.equals(title, bookStore.title) &&
                Objects.equals(author, bookStore.author) &&
                Objects.equals(Publisher, bookStore.Publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, Publisher);
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", Publisher='" + Publisher + '\'' +
                '}';
    }
}


