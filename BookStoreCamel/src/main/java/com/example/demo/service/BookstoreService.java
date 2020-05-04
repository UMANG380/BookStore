package com.example.demo.service;

import com.example.demo.exception.BookAlreadyPresentException;
import com.example.demo.exception.BookISbnNotFoundException;
import com.example.demo.model.Bookstore;
import java.util.Collection;

/*
 * Author: Umang Agarwal
 * Description: Bookstore Service Interface
 * Created On: 30/04/2020
 */

public interface BookstoreService {
    public Collection <Bookstore> viewAllBooks();
    public Bookstore viewBookByIsbn(int isbn) throws BookISbnNotFoundException;
    public Boolean updateBook(Bookstore bookstore) throws BookISbnNotFoundException;
    public String deleteBookByIsbn(int isbn) throws BookISbnNotFoundException;
    public Boolean addBook(Bookstore bookstore) throws BookAlreadyPresentException;
}