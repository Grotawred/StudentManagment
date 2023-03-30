package com.example.StudentManagment.exceptions;

public class AlereadyUsedEmailException extends RuntimeException{
    public AlereadyUsedEmailException(String message){
        super(message);
    }
}
