package com.example.demo.application.exception;

/**
 * Created by Michael on 16.07.2017.
 */
public class AccountFoundException extends Exception{

    public AccountFoundException() {

    }

    public AccountFoundException(String message) {
        super(message);
    }
}
