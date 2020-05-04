package com.example.demo.exception;

/*
 * Author: Umang Agarwal
 * Description: Exception class for Bookstore
 * Created On: 30/04/2020
 */

public class BookISbnNotFoundException extends Exception {
    public BookISbnNotFoundException(String message){
        super(message);
    }

}
