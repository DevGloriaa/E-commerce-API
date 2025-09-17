package com.example.ecommerceapi.exceptions;

public class HandleUserDoesNotExistException extends RuntimeException{
    public HandleUserDoesNotExistException(String message){
        super(message);
    }
}
