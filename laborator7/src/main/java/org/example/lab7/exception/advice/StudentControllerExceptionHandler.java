package org.example.lab7.exception.advice;

import org.example.lab7.exception.StudentAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, StudentAlreadyExistsException.class})
    public ResponseEntity<String> clientException(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
