package com.example.demo.dao;

import com.example.demo.model.Bookstore;
import java.util.Collection;

/*
 * Author: Umang Agarwal
 * Description: Dao interface for bookstore
 * Created On: 30/04/2020
 */

public interface BookstoreDao {
    public Collection <Bookstore> listAllBooks();
    public Bookstore listBookByIsbn(int isbn);
    public boolean updateBook(Bookstore bookstore);
    public boolean deleteBookByIsbn(int isbn);
    public Boolean addBook(Bookstore bookstore);
}