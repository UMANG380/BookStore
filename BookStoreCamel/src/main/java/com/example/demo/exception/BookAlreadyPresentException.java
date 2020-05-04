package com.example.demo.exception;

/*
 * Author: Umang Agarwal
 * Description: Book Already Present Exception
 * Created On: 04/05/2020
 */
public class BookAlreadyPresentException extends Exception{
    public BookAlreadyPresentException(String message){
        super(message);
    }
}
