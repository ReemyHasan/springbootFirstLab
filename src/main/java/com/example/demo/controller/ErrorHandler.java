package com.example.demo.controller;

import com.example.demo.exception.ApplicationError;
import com.example.demo.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Value("${api_doc_url}")
    private String Details;
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ApplicationError> handlePersonNotFound(PersonNotFoundException ex, WebRequest webRequest){
        ApplicationError error = new ApplicationError();
        error.setCode(1111);
        error.setMessage(ex.getMessage());
        error.setDetails(Details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
