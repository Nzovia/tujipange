package com.example.tujipange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * @author Nicholas Nzovia
 * @On 16/07/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex){

        //custom response
        String errorMessage = "Entity Not fount: "+ ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
