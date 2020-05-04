package com.example.demo.dao;

import com.example.demo.model.Bookstore;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;

/*
 * Author: Umang Agarwal
 * Description: Bookstore Dao class
 * Created On: 30/04/2020
 */

@Repository
public class BookstoreDaoImpl implements BookstoreDao {

    HashMap<Integer, Bookstore> hashMap = new HashMap<Integer, Bookstore>();

    Bookstore book1 = new Bookstore(1,"Harry Potter","J.K. Rowling","Bloomsbury");
    Bookstore book2 = new Bookstore(2,"The Da Vinci Code","Dan Brown","Doubleday");
    Bookstore book3 = new Bookstore(3,"War and Peace","Leo Tolstoy","The Russian Messenger ");
    Bookstore book4 = new Bookstore(4,"Lord of the Rings","J.R.R. Tolkien","Allen and Unwin");

    public BookstoreDaoImpl(){
        hashMap.put(1,book1);
        hashMap.put(2,book2);
        hashMap.put(3,book3);
        hashMap.put(4,book4);
    }

    @Override
    public Collection <Bookstore> listAllBooks() {
       for (Integer key: hashMap.keySet()) {
            System.out.println("id : " + key);
            System.out.println("Isbn " + hashMap.get(key).getIsbn());
            System.out.println("Title: " + hashMap.get(key).getTitle());
            System.out.println("Author" + hashMap.get(key).getAuthor());
            System.out.println("Publisher" + hashMap.get(key).getPublisher());
       }
        return hashMap.values();
    }

    @Override
    public Bookstore listBookByIsbn(int isbn) {
        Bookstore book = hashMap.get(isbn);
        return book;
    }

    @Override
    public boolean updateBook(Bookstore bookstore) {
        bookstore.setIsbn(bookstore.getIsbn());
        Bookstore book = hashMap.replace(bookstore.getIsbn(), bookstore);
        if(book == null)
            return false;
        return true;
    }

    @Override
    public boolean deleteBookByIsbn(int isbn) {
        if(hashMap.remove(isbn)!=null)
            return true;
        else
            return false;
    }

    @Override
    public Boolean addBook(Bookstore bookstore){
        Bookstore book1;
        boolean book=hashMap.containsKey(bookstore.getIsbn());
        if(book)
            return false;
        else
             book1 = hashMap.put(bookstore.getIsbn(), bookstore);
            return true;
    }
}
