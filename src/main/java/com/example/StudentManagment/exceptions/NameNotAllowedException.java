package com.example.StudentManagment.exceptions;

public class NameNotAllowedException extends RuntimeException{
    public NameNotAllowedException(String message){
        super(message);
    }
}
