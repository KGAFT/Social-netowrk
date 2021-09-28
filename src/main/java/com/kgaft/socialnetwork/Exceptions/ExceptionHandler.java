package com.kgaft.socialnetwork.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
//Exception handling
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Exception> handleException(AuthorizationServiceException exception) {
        Exception ex = new Exception();
        ex.setInfo(exception.getMessage());
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }
}


