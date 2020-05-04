package com.example.demo.service;

import com.example.demo.dao.BookstoreDao;
import com.example.demo.dao.BookstoreDaoImpl;
import com.example.demo.exception.BookAlreadyPresentException;
import com.example.demo.exception.BookISbnNotFoundException;
import com.example.demo.model.Bookstore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

/*
 * Author: Umang Agarwal
 * Description: Bookstore Service class
 * Created On: 30/04/2020
 */

@Service("bookService")
public class BookstoreServiceImpl implements BookstoreService {

    @Autowired
    BookstoreDao dao = new BookstoreDaoImpl();

    @Override
    public Collection<Bookstore> viewAllBooks() {
        return dao.listAllBooks();
    }

    @Override
    public Bookstore viewBookByIsbn(int isbn) throws BookISbnNotFoundException {
        Bookstore book = dao.listBookByIsbn(isbn);
        if(book!=null)
            return dao.listBookByIsbn(isbn);
        else
            throw new BookISbnNotFoundException("Book does not exist");
    }

    @Override
    public Boolean updateBook(Bookstore bookstore) throws BookISbnNotFoundException {
        boolean book=dao.updateBook(bookstore);
        if(book)
            return true;
        else
            throw new BookISbnNotFoundException("Book not found");
    }

    @Override
    public String deleteBookByIsbn(int isbn) throws BookISbnNotFoundException {
        Bookstore book = viewBookByIsbn(isbn);
        if(book!= null) {
            dao.deleteBookByIsbn(isbn);
            return "Book Deleted Successfully!";
        }
        else
            return "Book not found";
    }

    @Override
    public Boolean addBook(Bookstore bookstore) throws BookAlreadyPresentException {
        Boolean book = dao.addBook(bookstore);
        if(book)
            return  true;
        else
            throw new BookAlreadyPresentException("Book Already Present");
    }
}
