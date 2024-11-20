package org.example.lab7.exception;

public class StudentAlreadyExistsException extends RuntimeException{

    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
