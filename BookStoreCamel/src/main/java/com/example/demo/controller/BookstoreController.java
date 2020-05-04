/*package com.example.demo.controller;

import com.example.demo.exception.BookAlreadyPresent;
import com.example.demo.exception.BookIsbnNotFoundException;
import com.example.demo.model.Bookstore;
import com.example.demo.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


 * Author: Umang Agarwal
 * Description: Controller Class for Bookstore Functionalities
 * Created On: 30/04/2020

@RestController
@RequestMapping("bookstore/")
public class BookstoreController {

    @Autowired
    BookstoreService bookService;

    @GetMapping(value = "retrieveAll")                                          //Get Mapping for viewing all the books
    public Collection <Bookstore> list(Model model){
        return bookService.viewAllBooks();
    }

    @GetMapping( value = "book/{isbn}")                                         //Get mapping for viewing a specified book
    public Bookstore showBook(@PathVariable Integer isbn) throws BookIsbnNotFoundException {
        Bookstore bookstore = bookService.viewBookByIsbn(isbn);
        if(bookstore!= null)
            return bookstore;
        else
            throw new BookIsbnNotFoundException("Book Not Found");
    }

    @PostMapping(value="addBook")                                                //Post Mapping for add a book
    public ResponseEntity addBook(@RequestBody Bookstore book) throws BookAlreadyPresent {
        boolean book1=bookService.addBook(book);
        if(book1)
            return new ResponseEntity("Book added successfully", HttpStatus.OK);
        else
            throw new BookAlreadyPresent("Book already present");
    }

    @DeleteMapping(value="book/{isbn}")                                         //Delete mapping for deleting a book
    public ResponseEntity delete(@PathVariable Integer isbn) throws BookIsbnNotFoundException {
        Bookstore book = bookService.viewBookByIsbn(isbn);
        bookService.deleteBookByIsbn(isbn);
        if(book!=null)
            return new ResponseEntity("Book deleted successfully", HttpStatus.OK);
        throw new BookIsbnNotFoundException("Book Not found");
    }

    @PutMapping(value = "book/{isbn}")                                          //Put mapping for updating a book
    public ResponseEntity updateBookByIsbn(@PathVariable Integer isbn, @RequestBody Bookstore bookstore) throws BookIsbnNotFoundException {
        boolean book=bookService.updateBook(isbn, bookstore);
        if(book)
            return new ResponseEntity("Book updated successfully", HttpStatus.OK);
        else
            throw new BookIsbnNotFoundException("Book Not Found");
    }
}
*/